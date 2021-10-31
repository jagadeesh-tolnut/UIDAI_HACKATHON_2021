package com.example.aadhaar

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aadhaar.databinding.ActivityMainBinding
import android.os.Handler
import android.view.View


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Aadhaar)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginProgress.visibility = View.INVISIBLE
        //USER_PERMISSION
        if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(
                android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED  || checkSelfPermission(
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED
        ) {
            val permission =
                arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            requestPermissions(permission, 112)
        }
        binding.loginBtn.setOnClickListener {
            binding.loginProgress.visibility = View.VISIBLE
            val handler = Handler()
            handler.postDelayed({
                val intent = Intent(this, UserVerifyActivity::class.java)
                startActivity(intent)
                finish()
            }, 1500)

        }
    }
}