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

class MainActivity2 : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var map:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
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
        val coordinates= LatLng(9.993774, -84.131331)
        val coordinates2= LatLng(9.984375, -84.110618)
        val marker = MarkerOptions().position(coordinates).title("OXIGENO HEREDIA")
        val marker2 = MarkerOptions().position(coordinates2).title("PASEO DE LAS FLORES HEREDIA")
        map.addMarker(marker)
        map.addMarker(marker2)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 13f),
            4000,
            null
        )
    }
}