package com.utsman.binarku

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.gms.location.*
import com.google.android.material.snackbar.Snackbar
import com.utsman.binarku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val fusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(this)
    }

    private val launcherLocationPermission = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { isGranted ->
        val coarseResult = isGranted[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false
        val fineResult = isGranted[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        when {
            coarseResult -> requestLocation()
            fineResult -> requestLocation()
            else -> showSnackbar("permission denied")
        }
    }

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            val lat = location.latitude
            val lon = location.longitude

            val latLonText = "$lat,$lon"
            binding.tvResult.text = latLonText
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupGlide()

        binding.btnGetLocation.setOnClickListener {
            startRequestLocation()
        }
    }

    private fun setupGlide() {
        Glide.with(this)
            .load(IMAGE_URL)
            .placeholder(R.drawable.animated_webp_supported)
            .into(binding.imgMain)
    }

    private fun startRequestLocation() {
        if (isPermissionLocationGranted()) {
            requestLocation()
        } else {
            launcherLocationPermission.launch(arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ))
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestLocation() {
        showSnackbar("request location started...")
        val locationRequest = LocationRequest.Builder(500L)
            .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
            .setMinUpdateIntervalMillis(500L)
            .build()

        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationListener,
            Looper.getMainLooper()
        )

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                val lat = location?.latitude
                val lon = location?.longitude

                val latLonText = "$lat,$lon"
                binding.tvResult.text = latLonText
            }
            .addOnFailureListener {
                it.printStackTrace()
            }
    }

    private fun isPermissionLocationGranted(): Boolean {
        val isCoarsePermissionGranted = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val isFinePermissionGranted = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        return isCoarsePermissionGranted && isFinePermissionGranted
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        fusedLocationClient.removeLocationUpdates(locationListener)
    }

    companion object {
        private const val IMAGE_URL =
            "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg"
    }
}