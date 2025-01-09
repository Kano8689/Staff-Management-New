package com.example.staffmanagement

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val _loginBtn = findViewById<Button>(R.id.loginBtn)
        val _registerBtn = findViewById<Button>(R.id.registrBtn)
        _loginBtn.setOnClickListener{
            //validation of email and password
            this.startActivity(Intent(this,Login::class.java))
            finish()
        }
        _registerBtn.setOnClickListener{
            this.startActivity(Intent(this,Login::class.java))
            finish()
        }

        val _text = findViewById<TextView>(R.id.registrBtn)
        val fullText = "Already have an account?\nLogin here"
        val spannable = SpannableString(fullText)

        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#7D7E7E")),
            0,
            22,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#0A2241")),
            23,
            fullText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        _text.text = spannable

    }
}