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
import com.example.staffmanagement.MainActivity.PrefrenceDataObject._Editor
import com.example.staffmanagement.MainActivity.PrefrenceDataObject._PrefrenceData

class Login : AppCompatActivity() {
    lateinit var _DBObject : DataBaseManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        _DBObject = DataBaseManager(this)


        val _WorkPlaceDomain = findViewById<TextView>(R.id.WorkPlace_Domain)
        val _WorkPlaceName = findViewById<TextView>(R.id.WorkPlace_Name)
        val _UserName = findViewById<TextView>(R.id.UserNameEnter)
        val _UserPassword = findViewById<TextView>(R.id.PswdEnter)

        //on click login
        findViewById<TextView>(R.id.loginBtn).setOnClickListener{

            var workPlaceDomain:String = _WorkPlaceDomain.text.toString()
            var workPlaceName:String = _WorkPlaceName.text.toString()
            var userName:String = _UserName.text.toString()
            var userPassword:String = _UserPassword.text.toString()

            this.startActivity(Intent(this, DashboardMain::class.java))
            finish()

//            var isAvail =  _DBObject.SelectData4Login(workPlaceDomain,workPlaceName,userName,userPassword)
//            if(isAvail)
//            {
//                Log.d("Open Screen from Login", "isLogin: "+(_PrefrenceData.getBoolean("isLogin",false)))
//                _Editor.putBoolean("isLogin",true)
//                _Editor.apply()
//                Log.d("Open Screen from Login", "isLogin: "+(_PrefrenceData.getBoolean("isLogin",false)))
//                Toast.makeText(this,"Login Successfully",Toast.LENGTH_SHORT).show()
//                this.startActivity(Intent(this, DashboardMain::class.java))
//                finish()
//            }
//            else
//            {
//                Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show()
//            }
        }

        //on click rigister
        findViewById<Button>(R.id.registerBtn).setOnClickListener{
            this.startActivity(Intent(this,Register::class.java))
            finish()
        }

        val _text = findViewById<TextView>(R.id.registerBtn)
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