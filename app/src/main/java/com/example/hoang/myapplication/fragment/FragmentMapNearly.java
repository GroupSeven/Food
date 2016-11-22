package com.example.hoang.myapplication.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.helper.Data;
import com.example.hoang.myapplication.helper.GPSTracker;
import com.example.hoang.myapplication.model.StoreUser;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * Created by hoang o 21/11/2016.
 */

public class FragmentMapNearly extends Fragment {
    MapView mMapView;
    private GoogleMap googleMap;
    ArrayList<StoreUser> mStoreUsers;
    private CoordinatorLayout coordinatorLayout;
    MarkerOptions markerOptions;
    Marker marker;
    RelativeLayout mrootLayout;
    Snackbar snackbar;
    PolylineOptions polylineOptions;
    GPSTracker gpsTracker;

    CameraPosition myLocation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_map_nearly_layout, container, false);


        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.coordinatorLayout);
        mrootLayout = (RelativeLayout) rootView.findViewById(R.id.relativelayout);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
                setupCameraMap();
                setupMarker();
                setMylocation();
                myLocation = googleMap.getCameraPosition();
                LatLng currentLatLng = new LatLng(myLocation.target.latitude, myLocation.target.longitude);
                setupPoliline(Data.latLngHCM(), new LatLng(10.821833, 107.687178));
            }

            private void setupPoliline(LatLng currentLatLng, LatLng storeLatLng) {
                polylineOptions = new PolylineOptions();
                polylineOptions.add(currentLatLng);
                polylineOptions.add(storeLatLng);
                polylineOptions.color(android.R.color.holo_green_dark);
                googleMap.addPolyline(polylineOptions);
            }

            private void setupCameraMap() {
                LatLng sydney = new LatLng(10.821833, 106.887178);
                CameraUpdate mCameraUpdate = CameraUpdateFactory.newLatLngZoom(sydney, 8);

                /*
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(8).tilt(30).bearing(90).build();
                CameraUpdate mCameraUpdate2  = CameraUpdateFactory.newCameraPosition(cameraPosition);
                */
                googleMap.animateCamera(mCameraUpdate, 1000, null);


                googleMap.getUiSettings().setCompassEnabled(true);


            }


            private void setMylocation() {
                if (ActivityCompat.checkSelfPermission(rootView.getContext()
                        , Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(rootView.getContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)

                {
                    return;
                }
                googleMap.setMyLocationEnabled(true);


            }


            private void setupMarker() {
                mStoreUsers = new ArrayList<StoreUser>();
                mStoreUsers.addAll(Data.postLatLngStoreUser());
                for (int i = 0; i < mStoreUsers.size(); i++) {
                    LatLng mLatLng = new LatLng(mStoreUsers.get(i).getLat(), mStoreUsers.get(i).getLng());
                    markerOptions = new MarkerOptions();
                    markerOptions.position(mLatLng).title("Store").snippet("Name :D");
                    markerOptions.draggable(true);
                    googleMap.addMarker(markerOptions);

                    marker = googleMap.addMarker(markerOptions);
                    marker.showInfoWindow();


                }
                markerClickEvent();
            }

            private void markerClickEvent() {
                googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(final Marker marker) {

                        snackbar = Snackbar
                                .make(mrootLayout, " this is : " + marker.getTitle(), Snackbar.LENGTH_LONG);
                        snackbar.setAction("ef", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Toast.makeText(getContext(), " Start your activity, push sthing" + marker.getId().toString(), Toast.LENGTH_SHORT).show();

                            }
                        });
                        snackbar.show();
                    }

                });


                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        LatLng storeLatLng = marker.getPosition();
                        String huu = String.valueOf(storeLatLng.latitude);
                        gpsTracker = new GPSTracker(getContext());
                        Toast.makeText(getContext(), "clicked" + gpsTracker.getLatitude(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }


            void getCurrentLocation() {
                Location myLocation = googleMap.getMyLocation();
                if (myLocation != null) {
                    double dLatitude = myLocation.getLatitude();
                    double dLongitude = myLocation.getLongitude();
                    Log.i("APPLICATION", " : " + dLatitude);
                    Log.i("APPLICATION", " : " + dLongitude);
                    googleMap.addMarker(new MarkerOptions().position(
                            new LatLng(dLatitude, dLongitude)).title("My Location"));

                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(dLatitude, dLongitude), 8));

                } else {
                    Toast.makeText(getContext(), "Unable to fetch the current location", Toast.LENGTH_SHORT).show();
                }

            }

        });

        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


}