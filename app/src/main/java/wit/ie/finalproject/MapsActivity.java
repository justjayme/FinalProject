package wit.ie.finalproject;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        LatLng Boheme = new LatLng(52.2616883, -7.1838155);
        mMap.addMarker(new MarkerOptions().position(Boheme).title("La Boheme"));
        float zoomLevel = 15.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Boheme, zoomLevel));

        LatLng Momo = new LatLng(52.2600063, -7.1825515);
        mMap.addMarker(new MarkerOptions().position(Momo).title("Momo Restaurant"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Momo));

        LatLng Cafe = new LatLng(52.2613305,-7.1701769);
        mMap.addMarker(new MarkerOptions().position(Cafe).title("No 9 Café"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Cafe));

        LatLng Bell = new LatLng(52.2617802, -7.1834672);
        mMap.addMarker(new MarkerOptions().position(Bell).title("Bell Pepper"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bell));

        LatLng Moorings = new LatLng(52.0904593, -7.6204623);
        mMap.addMarker(new MarkerOptions().position(Moorings).title("The Moorings"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Moorings));

        LatLng Park = new LatLng(52.0917231, -7.624883);
        mMap.addMarker(new MarkerOptions().position(Park).title("The Park Hotel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Park));

        LatLng Lawlors = new LatLng(52.0898496, -7.62445);
        mMap.addMarker(new MarkerOptions().position(Lawlors).title("Lawlors"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Lawlors));



    }
}
