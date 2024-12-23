package com.example.staffmanagement

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DashboardMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard_main)

        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = 80f // Set corner radius (in dp or px)
        shape.setColor(ContextCompat.getColor(this, R.color.offWhite)) // Set color

        val whiteBG = findViewById<ImageView>(R.id.bg_white)
        whiteBG.background = shape

        val DashboardItems: List<ImageView> = listOf(
            findViewById(R.id.opt1),
            findViewById(R.id.opt2),
            findViewById(R.id.opt3),
            findViewById(R.id.opt4),
            findViewById(R.id.opt5),
            findViewById(R.id.opt6)
        )

        DashboardItems.forEach {
            // Create a new GradientDrawable for each ImageView
            val Shape = GradientDrawable().apply {
                cornerRadius = 80f
                setColor(ContextCompat.getColor(this@DashboardMain, R.color.white))
            }

            // Set the background for each ImageView
            it.background = Shape
        }

    }
}