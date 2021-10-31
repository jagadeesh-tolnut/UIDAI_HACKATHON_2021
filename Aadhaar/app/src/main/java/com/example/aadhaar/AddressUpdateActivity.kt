package com.example.aadhaar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.aadhaar.databinding.ActivityAddressUpdateBinding

class AddressUpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddressUpdateBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.areaInfo.setEnabled(false)
        binding.houseInfo.setEnabled(false)
        binding.landmarkInfo.setEnabled(false)
        binding.cityInfo.setEnabled(false)
        binding.streetInfo.setEnabled(false)
        binding.updateAdd.setEnabled(false)
        Toast.makeText(this, "Extracting Address", Toast.LENGTH_LONG).show()
        val handler = Handler()
        handler.postDelayed({
            binding.areaInfo.setEnabled(true)
            binding.houseInfo.setEnabled(true)
            binding.landmarkInfo.setEnabled(true)
            binding.cityInfo.setEnabled(true)
            binding.streetInfo.setEnabled(true)
            Toast.makeText(this, "Address retrieved successfully", Toast.LENGTH_SHORT).show()
            binding.houseInfo.setText("NO.45")
            binding.streetInfo.setText("N.R.Avenue")
            binding.areaInfo.setText("Agthiarkottam")
            binding.landmarkInfo.setText("Dharmapuri")
            binding.cityInfo.setText("Puducherry")
            binding.updateAdd.setEnabled(true)
        }, 4000)

        binding.updateAdd.setOnClickListener {
            val intent = Intent(this, FinalActivity::class.java)
            startActivity(intent)
        }
    }
}