
package com.example.aadhaar


import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.aadhaar.databinding.ActivityUserVerifyBinding
import android.os.Handler
import android.view.View


class UserVerifyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserVerifyBinding
    private val IMAGE_CAPTURE_CODE = 654
    var bitmapImage: Bitmap? = null
    var exportImage:Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.otpProgressBar.visibility = View.INVISIBLE
        binding.verifyOtpBtn.setOnClickListener {

            binding.otpProgressBar.visibility = View.VISIBLE
            val handler = Handler()
            handler.postDelayed({
                dispatchTakePictureIntent()
            }, 1000)

    }
}
    val REQUEST_IMAGE_CAPTURE = 1
    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val intent = Intent(this, AddressUpdateActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}