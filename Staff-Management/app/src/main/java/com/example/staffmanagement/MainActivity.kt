package com.example.staffmanagement

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.staffmanagement.MainActivity.PrefrenceDataObject._PrefrenceData
import com.example.staffmanagement.MainActivity.PrefrenceDataObject._Editor

class MainActivity : AppCompatActivity()
{
    object PrefrenceDataObject
    {
        lateinit var _PrefrenceData : SharedPreferences
        lateinit var _Editor : SharedPreferences.Editor
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        _PrefrenceData = getSharedPreferences("StaffManagement", MODE_PRIVATE)
        _Editor = _PrefrenceData.edit()

        val _process = findViewById<ProgressBar>(R.id.loadingSlider)
        val textView = findViewById<TextView>(R.id.progrressValue)

        // set full width in display
        val displayMetrics = resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels
        val screenHeight = displayMetrics.heightPixels
        val width90Percent = (screenWidth * 0.8).toInt()
        val params = _process.layoutParams
        params.width = width90Percent
        _process.layoutParams = params

        var _scaleLoad:Float = 1.5f
        _process.max = 100
        _process.scaleY = _scaleLoad
        _process.scaleX = _scaleLoad
        val loadingAnim = LoadingAnimation(
            this,_process, textView, 0F, 100F,
        )
        loadingAnim.duration = 3000
        _process.animation = loadingAnim

        val _logo = findViewById<ImageView>(R.id.splashLogo)
        val logoAnim = LoadingImage(
            _logo, 0.3f,1f,0.5f,1f,0,360
        )
        logoAnim.duration = 2000
        _logo.animation = logoAnim
    }
    fun OpenActivity(isNew:Boolean){
        if(isNew)
        {
            startActivity(Intent(this, DashboardMain::class.java))
            finish()
        }
        else
        {
            startActivity(Intent(this, Login::class.java))
            finish()
        }
    }
}
