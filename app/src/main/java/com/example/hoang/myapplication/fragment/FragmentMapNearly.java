package com.example.hoang.myapplication.fragment;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
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
import com.example.hoang.myapplication.maps.DirectionFinder;
import com.example.hoang.myapplication.maps.DirectionFinderListener;
import com.example.hoang.myapplication.maps.Route;
import com.example.hoang.myapplication.model.StoreUser;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoang o 21/11/2016.
 */

public class FragmentMapNearly extends Fragment implements DirectionFinderListener {
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

    Location l;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;


    View rootView;
    Location mLocation;
    LocationManager locationManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_map_nearly_layout, container, false);

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
                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                setMylocationButton();
                setupCameraMap();
                setupMarker();


                googleMap.getUiSettings().setZoomControlsEnabled(true);
            }


        });

        return rootView;
    }


    //////////////////////////////////

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


    private void setMylocationButton() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            System.out.println("CHECK_RUN_TIME_PERMISSION_IF_MARSHMELLOW");
            if (!checkPermission()) {
                requestPermission();
            } else {
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

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(rootView.getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED) {

            return true;

        } else {

            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {

            Toast.makeText(getContext(), "GPS permission allows us to access location data. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);

        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
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
//                setupPoliline(storeLatLng, myLocation());
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
                l = googleMap.getMyLocation();

                drawPolyline(String.valueOf(l.getLatitude()) + "," + String.valueOf(l.getLongitude()), String.valueOf(marker.getPosition().latitude) + "," + String.valueOf(marker.getPosition().longitude));

                return false;
            }
        });
    }

    private void setupCameraMap() {
        final LatLng sydney = new LatLng(10.821833, 106.887178);
        CameraUpdate mCameraUpdate = CameraUpdateFactory.newLatLngZoom(sydney, 9);

                /*
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(8).tilt(30).bearing(90).build();
                CameraUpdate mCameraUpdate2  = CameraUpdateFactory.newCameraPosition(cameraPosition);
                */
        googleMap.animateCamera(mCameraUpdate, 1000, null);


        googleMap.getUiSettings().setCompassEnabled(true);


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
                    Toast.makeText(getContext(), "Permission Granted, Now you can access location data.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Permission Denied, You cannot access location data.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


    private void drawPolyline(String origin, String destination) {

        if (origin.isEmpty()) {
            Toast.makeText(getContext(), "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (destination.isEmpty()) {
            Toast.makeText(getContext(), "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(getContext(), "Please wait.",
                "Finding direction..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline : polylinePaths) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(route.endLocation));
            snackbar = Snackbar
                    .make(mrootLayout, " Đây là cửa hàng : " + marker.getTitle()
                            +" \ncách bạn " + route.distance.text
                            + " , đi khoảng:  "
                            + route.duration.text + " là tới" , Snackbar.LENGTH_LONG);
            snackbar.setAction("ActionButton    ", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Acction here", Toast.LENGTH_SHORT).show();
                }
            });
            snackbar.show();



            originMarkers.add(googleMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_clear_black_24dp))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(googleMap.addMarker(new MarkerOptions()
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic))
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(googleMap.addPolyline(polylineOptions));
        }
    }


}