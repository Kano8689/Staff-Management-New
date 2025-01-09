package com.example.staffmanagement

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.staffmanagement.MainActivity.PrefrenceData._SharedPreferences

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val email = findViewById<TextView>(R.id.emailEditText)
        val password = findViewById<TextView>(R.id.pswdEditText)
        val domain = findViewById<TextView>(R.id.usernameEditText)

        val _loginBtn = findViewById<Button>(R.id.loginBtn)
        val _registerBtn = findViewById<TextView>(R.id.registrBtn)

        var wrkdmn = _SharedPreferences.getString("WorkDomain",null)
        var orgnName = _SharedPreferences.getString("OrganizationName",null)
        var pwd = _SharedPreferences.getString("Password",null)
        _loginBtn.setOnClickListener{
            if(orgnName!=null && pwd!=null && wrkdmn!=null)
            {
                if(email.text==orgnName && password.text==pwd && domain.text==wrkdmn)
                {
                    _SharedPreferences.edit().putBoolean("isLogin", true).apply()
                    this.startActivity(Intent(this,DashboardMain::class.java))
                    finish()
                }
                else
                {
                    Toast.makeText(this,"Invalid Email or Password..1",Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this,"Invalid Email or Password..2",Toast.LENGTH_SHORT).show()
            }
        }

        _registerBtn.setOnClickListener{
            this.startActivity(Intent(this,Register::class.java))
            finish()
        }

        val _text = findViewById<TextView>(R.id.registrBtn)
        val fullText = "Don't you have an account?\nCreate an account"
        val spannable = SpannableString(fullText)

        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#7D7E7E")),
            0,
            26,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#0A2241")),
            26,
            fullText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        _text.text = spannable
    }
}