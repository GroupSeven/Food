//package com.example.hoang.myapplication.activity;
//
//import android.Manifest;
//import android.app.ProgressDialog;
//import android.content.pm.PackageManager;
//import android.graphics.Color;
//import android.location.Location;
//import android.os.Bundle;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.akexorcist.googledirection.DirectionCallback;
//import com.akexorcist.googledirection.GoogleDirection;
//import com.akexorcist.googledirection.model.Direction;
//import com.example.hoang.myapplication.R;
//import com.example.hoang.myapplication.helper.Data;
//import com.example.hoang.myapplication.maps.DirectionFinder;
//import com.example.hoang.myapplication.maps.DirectionFinderListener;
//import com.example.hoang.myapplication.maps.Route;
//import com.example.hoang.myapplication.model.StoreUser;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.maps.model.Polyline;
//import com.google.android.gms.maps.model.PolylineOptions;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.ButterKnife;
//
//public class TrackerActivity extends AppCompatActivity implements OnMapReadyCallback, DirectionFinderListener {
//    private static final int PERMISSION_REQUEST_CODE = 123;
//    private static final String serverk = "AIzaSyBIdAAndTRHHYwG99_xQ1I0BeMNMlXbz28";
//    FirebaseUser user;
//    FirebaseAuth mAuth;
//    private ArrayList<StoreUser> mStoreUsers;
//    MarkerOptions markerOptions;
//    Polyline polyline;
//    Marker marker;
//    Toolbar toolbar;
//    GoogleMap mMap;
//    MapFragment mapFragment;
//    Location mLocation;
//    Double currentLat = 10.8;
//    Double currentLng = 10.8;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tracker);
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.mapabc);
//        mapFragment.getMapAsync(this);
//        ButterKnife.bind(this);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        user = FirebaseAuth.getInstance().getCurrentUser();
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // config UI,
//        configMap();
//
//        // marker of market
//        setupMarket();
//
//        // showCurrent location and marker
//        setOnMyLocationButtonClickEvent();
//
//        // marker click action
//        markerClickEvent();
//
//    }
//
//
//    /* ============================================*************************************************** */
//
//
//    private void markerClickEvent() {
//
//        // clear polyline
////        polyline.remove();
//
//        // click icon
//        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                Toast.makeText(getApplicationContext(), "ĐÃ lích marker", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//        // click thông tin
//        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
//            @Override
//            public void onInfoWindowClick(Marker marker) {
//                Location crLct = mMap.getMyLocation();
//
//                polyline = mMap.addPolyline(new PolylineOptions().add(
//                        new LatLng(crLct.getLatitude(), crLct.getLongitude()),
//                        new LatLng(marker.getPosition().latitude, marker.getPosition().longitude)
//                ).width(10)
//                        .color(Color.GREEN));
//
//
//            }
//        });
//    }
//
//    private void setupMarket() {
//        mStoreUsers = new ArrayList<StoreUser>();
//        mStoreUsers.addAll(Data.UserFulldetail());
//        for (int i = 0; i < mStoreUsers.size(); i++) {
//            LatLng mLatLng = new LatLng(mStoreUsers.get(i).getLat(), mStoreUsers.get(i).getLng());
//            markerOptions = new MarkerOptions();
//            markerOptions.position(mLatLng)
//                    .title(mStoreUsers.get(i).getName())
//                    .snippet(mStoreUsers.get(i).getPhone())
//                    .draggable(true)
//                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
//
//            mMap.addMarker(markerOptions);
//
//            marker = mMap.addMarker(markerOptions);
//            marker.showInfoWindow();
//            markerOptions.draggable(true);
//
//        }
//    }
//
//    public void setCurrentMarker() {
//        mMap.clear();
//        setupMarket();
//        mLocation = mMap.getMyLocation();
//        LatLng mLatLng = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());
//        markerOptions = new MarkerOptions();
//        markerOptions.position(mLatLng)
//                .title("Đây là bạn")
//                .snippet("Bạn rất là vãi")
//                .draggable(true)
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
//
//        mMap.addMarker(markerOptions);
//
//        marker = mMap.addMarker(markerOptions);
//        marker.showInfoWindow();
//        markerOptions.draggable(true);
//    }
//
//    private void setOnMyLocationButtonClickEvent() {
//        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
//            @Override
//            public boolean onMyLocationButtonClick() {
//
//                // request ***************
//                sendRequest();
//                setCurrentMarker();
//
//                Location lct = mMap.getMyLocation();
//
//                GoogleDirection.withServerKey(serverk)
//                        .from(Data.latLngHCM())
//                        .to(new LatLng(lct.getLatitude(), lct.getLongitude()))
//                        .execute(new DirectionCallback() {
//                            @Override
//                            public void onDirectionSuccess(Direction direction, String rawBody) {
//                                Toast.makeText(getApplicationContext(), "Action ok", Toast.LENGTH_SHORT).show();
//                                if (direction.isOK()) {
//                                    Toast.makeText(getApplicationContext(), "direction.isOK ok", Toast.LENGTH_SHORT).show();
//
//                                } else {
//                                    Toast.makeText(getApplicationContext(), " không direction.isOK ok", Toast.LENGTH_SHORT).show();
//
//                                }
//
//                            }
//
//                            @Override
//                            public void onDirectionFailure(Throwable t) {
//                                Toast.makeText(getApplicationContext(), "Action failed" + t.toString(), Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
//                Toast.makeText(getApplicationContext(), "Mylocation button", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//    }
//
//    private void sendRequest() {
//
//        String origin = String.valueOf(Data.latLngHCM());
//        String destination = String.valueOf(Data.latLngHCM2());
//        // Quawng zo day
//        if (origin.isEmpty()) {
//            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (destination.isEmpty()) {
//            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        try {
//            new DirectionFinder(this, origin, destination).execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void configMap() {
//        setMylocationButton();
//
//        // la bàn
//        mMap.getUiSettings().setCompassEnabled(true);
//
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Data.latLngHCM(), 7));
//    }
//
//
//    private void setMylocationButton() {
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//            System.out.println("CHECK_RUN_TIME_PERMISSION_IF_MARSHMELLOW");
//            if (!checkPermission()) {
//                requestPermission();
//            } else {
//                System.out.println("CHECK_RUN_TIME_PERMISSION_IF_MARSHMELLOW++");
//            }
//        }
//
//        /// old
//        if (ActivityCompat.checkSelfPermission(getApplicationContext()
//                , Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(getApplicationContext(),
//                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
//
//        {
//            return;
//        }
//        mMap.setMyLocationEnabled(true);
//
//
//    }
//
//    private boolean checkPermission() {
//        int result = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);
//        if (result == PackageManager.PERMISSION_GRANTED) {
//
//            return true;
//
//        } else {
//
//            return false;
//        }
//    }
//
//    private void requestPermission() {
//
//        if (ActivityCompat.shouldShowRequestPermissionRationale(TrackerActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)) {
//
//            Toast.makeText(getApplicationContext(), "GPS permission allows us to access location data. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
//            ActivityCompat.requestPermissions(TrackerActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
//
//        } else {
//            ActivityCompat.requestPermissions(TrackerActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar_menu_tracker, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.itShowStore:
//                setupMarket();
//                break;
//            case R.id.itChuabiet:
//                mLocation = mMap.getMyLocation();
//                mMap.clear();
//                marker.remove();
//                Toast.makeText(getApplicationContext(), "" + currentLat + "--" + currentLng, Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.itRemovePoline:
//            default:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//    @Override
//    public void onDirectionFinderStart() {
//        progressDialog = ProgressDialog.show(this, "Please wait.",
//                "Finding direction..!", true);
//
//        if (originMarkers != null) {
//            for (Marker marker : originMarkers) {
//                marker.remove();
//            }
//        }
//
//        if (destinationMarkers != null) {
//            for (Marker marker : destinationMarkers) {
//                marker.remove();
//            }
//        }
//
//        if (polylinePaths != null) {
//            for (Polyline polyline : polylinePaths) {
//                polyline.remove();
//            }
//        }
//    }
//
//
//    @Override
//    public void onDirectionFinderSuccess(List<Route> routes) {
//        progressDialog.dismiss();
//        polylinePaths = new ArrayList<>();
//        originMarkers = new ArrayList<>();
//        destinationMarkers = new ArrayList<>();
//
//        for (Route route : routes) {
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
//            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
//            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);
//
//            originMarkers.add(mMap.addMarker(new MarkerOptions()
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
//                    .title(route.startAddress)
//                    .position(route.startLocation)));
//            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
//                    .title(route.endAddress)
//                    .position(route.endLocation)));
//
//            PolylineOptions polylineOptions = new PolylineOptions().
//                    geodesic(true).
//                    color(Color.BLUE).
//                    width(10);
//
//            for (int i = 0; i < route.points.size(); i++)
//                polylineOptions.add(route.points.get(i));
//
//            polylinePaths.add(mMap.addPolyline(polylineOptions));
//        }
//    }
//
//}
