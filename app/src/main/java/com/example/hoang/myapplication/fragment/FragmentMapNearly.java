package com.example.hoang.myapplication.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.helper.Data;
import com.example.hoang.myapplication.model.StoreUser;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * Created by hoang o 21/11/2016.
 */

public class FragmentMapNearly extends Fragment {
    private static final int PERMISSION_REQUEST_CODE = 11;
    private MapView mMapView;
    private GoogleMap googleMap;
    private ArrayList<StoreUser> mStoreUsers;
    private CoordinatorLayout coordinatorLayout;
    private MarkerOptions markerOptions;
    private Marker marker;
    private RelativeLayout mrootLayout;
    private Snackbar snackbar;
    private PolylineOptions polylineOptions;

    Location mLocation;

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
            public static final int PERMISSION_REQUEST_CODE = 11;

            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
//                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                setupCameraMap();
                setupMarker();
                setMylocationButton();
            }

            private void setupPoliline(LatLng currentLatLng, LatLng storeLatLng) {
                polylineOptions = new PolylineOptions();
                polylineOptions.add(currentLatLng);
                polylineOptions.add(storeLatLng);
                polylineOptions.color(R.color.colorRed);
                googleMap.addPolyline(polylineOptions);

            }

            private LatLng myLocation() {
                mLocation = googleMap.getMyLocation();
                if (mLocation == null) {
                    return new LatLng(10, 123);
                } else {
                    return new LatLng(mLocation.getLatitude(), mLocation.getLongitude());
                }
            }

            private void setupCameraMap() {
                final LatLng sydney = new LatLng(10.821833, 106.887178);
                CameraUpdate mCameraUpdate = CameraUpdateFactory.newLatLngZoom(sydney, 8);

                /*
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(8).tilt(30).bearing(90).build();
                CameraUpdate mCameraUpdate2  = CameraUpdateFactory.newCameraPosition(cameraPosition);
                */
                googleMap.animateCamera(mCameraUpdate, 1000, null);


                googleMap.getUiSettings().setCompassEnabled(true);


            }


            private void setMylocationButton() {
                // new

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
                {
                    System.out.println("CHECK_RUN_TIME_PERMISSION_IF_MARSHMELLOW");
                    if(!checkPermission()) {
                        requestPermission();
                    }else {
                        System.out.println("CHECK_RUN_TIME_PERMISSION_IF_MARSHMELLOW++");
                    }
                }

                /// old
                if (ActivityCompat.checkSelfPermission(rootView.getContext()
                        , Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(rootView.getContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)

                {
                    return;
                }
                googleMap.setMyLocationEnabled(true);

            }

            private boolean checkPermission(){
                int result = ContextCompat.checkSelfPermission(rootView.getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
                if (result == PackageManager.PERMISSION_GRANTED){

                    return true;

                } else {

                    return false;
                }
            }
            private void requestPermission(){

                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION)){

                    Toast.makeText(getContext(),"GPS permission allows us to access location data. Please allow in App Settings for additional functionality.",Toast.LENGTH_LONG).show();
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_REQUEST_CODE);

                } else {
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_REQUEST_CODE);
                }
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
                        LatLng storeLatLng = new LatLng(marker.getPosition().latitude, marker.getPosition().longitude);
                        setupPoliline(storeLatLng, myLocation());
                        snackbar = Snackbar
                                .make(mrootLayout, " this is : " + marker.getTitle(), Snackbar.LENGTH_LONG);
                        snackbar.setAction("ef", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getContext(), "--+Start your activity, push sthing", Toast.LENGTH_SHORT).show();
                            }
                        });
                        snackbar.show();
                    }

                });


                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
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


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getContext(),"Permission Granted, Now you can access location data.",Toast.LENGTH_LONG).show();


                } else {

                    Toast.makeText(getContext(),"Permission Denied, You cannot access location data.",Toast.LENGTH_LONG).show();

                }
                break;
        }
    }
}