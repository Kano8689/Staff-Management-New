package com.example.staffmanagement

import android.os.Bundle
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
        loadingAnim.duration = 8000
        _process.animation = loadingAnim
    }
}
