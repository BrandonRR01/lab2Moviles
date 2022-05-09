package com.example.mapslab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var map:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment()
    }

    private fun createFragment(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
      map = googleMap
     createMarker()
    }
    private fun createMarker(){
        val coordinates= LatLng(10.005624, -84.211472)
        val marker = MarkerOptions().position(coordinates).title("CITY MALL ALAJUELA")
        map.addMarker(marker)
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 17f),
            4000,
            null
        )
    }
}