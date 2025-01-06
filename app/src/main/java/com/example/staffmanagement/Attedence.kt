package com.example.staffmanagement

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Attedence : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_attedence)

        var backBtn: ImageButton = findViewById(R.id.backButton)
        backBtn.setOnClickListener{
            this.startActivity(Intent(this,DashboardMain::class.java))
        }

    }
}