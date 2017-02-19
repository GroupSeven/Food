package com.example.hoang.myapplication.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.helper.Data;
import com.example.hoang.myapplication.helper.Helper;
import com.example.hoang.myapplication.maps.DirectionFinder;
import com.example.hoang.myapplication.maps.DirectionFinderListener;
import com.example.hoang.myapplication.maps.Route;
import com.example.hoang.myapplication.model.StoreUser;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hoang on 2016/11/26.
 */

public class TclassActivity extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener {

    private static final int PERMISSION_REQUEST_CODE = 121;
    private GoogleMap mMap;
//    private Button btnFindPath;
//    private EditText etOrigin;
//    private EditText etDestination;

    //    @BindView(R.id.btnFindPath)
//    Button btnFindPath;
    @BindView(R.id.etOrigin)
    EditText etOrigin;
    @BindView(R.id.etDestination)
    EditText etDestination;

    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();

    private ArrayList<StoreUser> mStoreUsers;

    private ProgressDialog progressDialog;

    Marker mMarker;
    MarkerOptions markerOptions;

    Location l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_activity);
        ButterKnife.bind(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        findView();
        clickFind();


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mapConfig();

        MyLocationButtonEven();

        setUpMylocationButton();

        markerClickDrawPolyEven();

        // fake store
        fakeMarerStore();

        mMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {
            @Override
            public void onCameraMoveStarted(int i) {
                Helper.showToast(getApplicationContext(), "strated");
            }
        });

        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                Toast.makeText(getApplicationContext(), "" + String.valueOf(cameraPosition.bearing), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void markerClickDrawPolyEven() {

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                l = mMap.getMyLocation();
                String origin = String.valueOf(l.getLatitude() + "," + String.valueOf(l.getLongitude()));
                String destination = String.valueOf(marker.getPosition().latitude) + "," + String.valueOf(marker.getPosition().longitude);
                Log.d("O-D", origin + "----" + destination);
                drawPolyline(origin, destination);
                Toast.makeText(TclassActivity.this, "" + marker.getPosition().latitude + marker.getPosition().longitude, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }


    /// done

    private void fakeMarerStore() {
        mStoreUsers = new ArrayList<StoreUser>();
        mStoreUsers.addAll(Data.UserFulldetail());
        for (int i = 0; i < mStoreUsers.size(); i++) {
            LatLng mLatLng = new LatLng(mStoreUsers.get(i).getLat(), mStoreUsers.get(i).getLng());
            markerOptions = new MarkerOptions();
            markerOptions.position(mLatLng)
                    .title(mStoreUsers.get(i).getName())
                    .snippet(mStoreUsers.get(i).getPhone())
                    .draggable(true)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.loolilop));

            mMap.addMarker(markerOptions);

            mMarker = mMap.addMarker(markerOptions);
            mMarker.showInfoWindow();
            markerOptions.draggable(true);

        }
    }

    private void mapConfig() {
        LatLng hcmus = new LatLng(10.762963, 106.682394);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hcmus, 10));
        markerOptions = new MarkerOptions().position(hcmus)
                .title("Đại học Khoa học tự nhiên");
        mMap.addMarker(markerOptions);

    }

    private void MyLocationButtonEven() {
        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
//                mMap.clear();

                l = mMap.getMyLocation();
                markerOptions = new MarkerOptions();
                markerOptions.position(new LatLng(l.getLatitude(), l.getLongitude()))
                        .title("Đây là bạn")
                        .snippet("Bạn rất là vãi")
                        .draggable(true)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                // dong nay voi dong duoi giong nhau
                mMap.addMarker(markerOptions);
                mMarker = mMap.addMarker(markerOptions);
                Helper.showToast(getApplicationContext(), "click ok nha");
                return false;
            }
        });
    }

    private void clickFind() {
//        btnFindPath.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendRequest();
//            }
//        });
    }

    private void sendRequest() {
        String origin = etOrigin.getText().toString();
        String destination = etDestination.getText().toString();
        if (origin.isEmpty()) {
            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (destination.isEmpty()) {
            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void drawPolyline(String origin, String destination) {

        if (origin.isEmpty()) {
            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (destination.isEmpty()) {
            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    private void setUpMylocationButton() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            Toast.makeText(getApplicationContext(), "CHECK_RUN_TIME_PERMISSION_IF_MARSHMELLOW", Toast.LENGTH_SHORT).show();
            if (!checkPermission()) {
                requestPermission();
            } else {
                Toast.makeText(getApplicationContext(), "CHECK_RUN_TIME_PERMISSION_IF_MARSHMELLOW++", Toast.LENGTH_SHORT).show();
            }
        }

        /// old
        if (ActivityCompat.checkSelfPermission(getApplicationContext()
                , Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)

        {
            return;
        }
        mMap.setMyLocationEnabled(true);


    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED) {

            return true;

        } else {

            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(TclassActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            Toast.makeText(getApplicationContext(), "GPS permission allows us to access location data. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(TclassActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);

        } else {
            ActivityCompat.requestPermissions(TclassActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
        }
    }

    private void findView() {

//        btnFindPath = (Button) findViewById(R.id.btnFindPath);
        etOrigin = (EditText) findViewById(R.id.etOrigin);
        etDestination = (EditText) findViewById(R.id.etDestination);
    }


    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Please wait.",
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
            mMap.moveCamera(CameraUpdateFactory.newLatLng(route.endLocation));
            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_clear_black_24dp))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
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

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }
}
