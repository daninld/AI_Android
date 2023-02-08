package com.example.ai_plus

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val cameraBtn = findViewById<Button>(R.id.upload) as Button
        cameraBtn.setOnClickListener(View.OnClickListener {
            val PERMISSION_CAMERA = 100
            requirePermissions(arrayOf(Manifest.permission.CAMERA), PERMISSION_CAMERA)

        })*/




    }



    // result 누르면 DetectedActivity로 넘어감
    fun onResultbtnClicked(v: View?) {
        val intent = Intent(this@MainActivity, DetectedActivity::class.java)
        startActivity(intent)
    }



}






