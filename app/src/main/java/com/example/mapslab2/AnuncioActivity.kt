package com.example.mapslab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mapslab2.databinding.ActivityAnuncioBinding

import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback



class AnuncioActivity : AppCompatActivity() {


    private lateinit var ad: AdView
    private lateinit var binding: ActivityAnuncioBinding
    private var adI: InterstitialAd? = null

    private var count = 1
    private  val TAG = "AnuncioActivity"

    private lateinit var adLoader: AdLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnuncioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MobileAds.initialize(this)

        initAds()
        binding.btnA1.setOnClickListener{
            count+=1
            checkCounter()
        }

    }
    fun initAds(){
        ad = findViewById(R.id.adBanner)
        val adRequest = AdRequest.Builder().build()
        ad.loadAd(adRequest)

        ad.adListener = object : AdListener(){
            override fun onAdLoaded() {
                Log.d(TAG, "El anuncio banner se cargo correctamente")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                Log.d(TAG, "El anuncio banner fallo al cargar")
            }

            override fun onAdOpened() {
                Log.d(TAG, "El anuncio banner se abrio correctamente")
            }

            override fun onAdClicked() {
                Log.d(TAG, "Se dio click al anuncio banner")
            }

            override fun onAdClosed() {
                Log.d(TAG, "El anuncio banner se cerro correctamente")
            }
        }
    }
    fun initInterstitial(){
        var adR = AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adR,
            object : InterstitialAdLoadCallback(){
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    adI= interstitialAd
                    Log.d(TAG, "El anuncio intertitial se cargo correctamente")

                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    adI = null
                    Log.d(TAG, "El anuncio intertitial fallo al cargar")
                }
            })
    }
    fun checkCounter(){
        if(count == 2){
            adI?.show(this)
            count=0
            initInterstitial()
        }
    }

}