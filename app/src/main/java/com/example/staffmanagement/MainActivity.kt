package com.example.staffmanagement

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        _process.max = 100
        _process.scaleY = 3f
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
}
