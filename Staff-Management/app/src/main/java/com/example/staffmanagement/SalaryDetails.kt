package com.example.staffmanagement

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SalaryDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_salary_details)

        var backBtn: ImageButton = findViewById(R.id.backButton)
        backBtn.setOnClickListener{
            this.startActivity(Intent(this,DashboardMain::class.java))
        }

    }
}