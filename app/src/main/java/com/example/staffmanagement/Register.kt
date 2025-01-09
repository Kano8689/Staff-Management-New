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
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.staffmanagement.MainActivity.PrefrenceData._Editor

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)


        val workDomain = findViewById<TextView>(R.id.workDomain)
        val email = findViewById<TextView>(R.id.emailEditText)
        val password = findViewById<TextView>(R.id.pswdEditText)
        val cnfmPassword = findViewById<TextView>(R.id.cnfmPswdEditText)

        val _registerBtn = findViewById<TextView>(R.id.registrBtn)
        val _loginBtn = findViewById<Button>(R.id.loginBtn)
        _registerBtn.setOnClickListener{
            //validation of email and password

            if(workDomain.text!="" && email.text!="" && password.text!="" && cnfmPassword.text!="")
            {
                if(password.text.toString() == cnfmPassword.text.toString()) {
                    _Editor.putString("WorkDomain", workDomain.text.toString())
                    _Editor.putString("OrganizationName", email.text.toString())
                    _Editor.putString("Password", password.text.toString())
                    _Editor.apply()
                    this.startActivity(Intent(this, Login::class.java))
                    finish()
                }
                else
                {
                    Toast.makeText(this,"Password doesn't match", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this,"Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
        _loginBtn.setOnClickListener{
            this.startActivity(Intent(this,Login::class.java))
            finish()
        }

        val _text = findViewById<TextView>(R.id.loginBtn)
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