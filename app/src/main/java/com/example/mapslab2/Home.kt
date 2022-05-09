package com.example.mapslab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import com.google.android.gms.ads.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    fun mapAlajuela(view: View) {
        val alajuela = Intent(this, MainActivity::class.java)
        startActivity(alajuela)
    }
    fun mapHeredia(view: View) {
        val heredia = Intent(this, MainActivity2::class.java)
        startActivity(heredia)
    }
    fun anuncios(view: View) {
        val a = Intent(this, AnuncioActivity::class.java)
        startActivity(a)
    }

}