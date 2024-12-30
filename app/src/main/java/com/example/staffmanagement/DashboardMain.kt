package com.example.staffmanagement

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class DashboardMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard_main)

        //options background
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = 80f // Set corner radius (in dp or px)
        shape.setColor(ContextCompat.getColor(this, R.color.offWhite)) // Set color
        val whiteBG = findViewById<ImageView>(R.id.bg_white)
        whiteBG.background = shape

        //profile picture
        val profilePic = findViewById<ImageButton>(R.id.profile_pic)



        val DashboardItems: List<ImageButton> = listOf(
            findViewById(R.id.project_task),
            findViewById(R.id.task_done),
            findViewById(R.id.attedence),
            findViewById(R.id.leaves),
            findViewById(R.id.salary_detail),
            findViewById(R.id.team)
        )

        val gridLayout = GridLayout(this).apply {
            rowCount = 3
            columnCount = 2
            useDefaultMargins = true
            setPadding(16, 16, 16, 16)
            alignmentMode = GridLayout.ALIGN_BOUNDS
            orientation = GridLayout.HORIZONTAL
        }
    }
}