package com.example.staffmanagement

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

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

        val DashboardItems: List<ImageButton> = listOf(
            findViewById(R.id.project_task),
            findViewById(R.id.task_done),
            findViewById(R.id.attedence),
            findViewById(R.id.leaves),
            findViewById(R.id.salary_detail),
            findViewById(R.id.team)
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