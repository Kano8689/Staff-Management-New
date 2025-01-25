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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import java.net.HttpURLConnection
import java.net.URL

class Register : AppCompatActivity() {
    lateinit var _DBObject : DataBaseManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        _DBObject = DataBaseManager(this)

        val _WorkPlaceDomain = findViewById<TextView>(R.id.WorkPlace_Domain)
        val _WorkPlaceName = findViewById<TextView>(R.id.WorkPlace_Name)
        val _WorkPlaceEmail = findViewById<TextView>(R.id.WorkPlace_Email)
        val _WorkPlacePassword = findViewById<TextView>(R.id.WorkPlace_Pswd)
        val _WorkPlaceCnfmPassword = findViewById<TextView>(R.id.WorkPlace_CnfmPswd)


        //on click register
        findViewById<TextView>(R.id.registerBtn).setOnClickListener{
            var workPlaceDomain:String = _WorkPlaceDomain.text.toString()
            var workPlaceName:String = _WorkPlaceName.text.toString()
            var workPlaceEmail:String = _WorkPlaceEmail.text.toString()
            var workPlacePswd:String = _WorkPlacePassword.text.toString()
            var workPlaceCnfmPswd:String = _WorkPlaceCnfmPassword.text.toString()

//            this.startActivity(Intent(this, Login::class.java))
//            finish()

            Log.d("Register Log KKK", "Password: $workPlacePswd")
            Log.d("Register Log KKK", "Password: $workPlaceCnfmPswd")
            Log.d("Register Log KKK", "Password: "+(workPlacePswd.compareTo(workPlaceCnfmPswd)))
            if(workPlacePswd.compareTo(workPlaceCnfmPswd) == 0)
            {
                SendRegisterRequest(workPlaceDomain, workPlaceName, workPlaceEmail, workPlacePswd);
            }
            else
            {
                Toast.makeText(this,"Password not matched",Toast.LENGTH_SHORT).show()
            }
        }

        //on click login
        findViewById<Button>(R.id.loginBtn).setOnClickListener{
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


    fun SendRegisterRequest(workPlaceDomain: String, workPlaceName: String, workPlaceEmail: String, workPlacePswd: String)
    {
        var isAvail:Boolean = false;
        var isRegister:Boolean = false;

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    val url = URL("http://localhost:3330/CompanyRegister")
                    val connection = url.openConnection() as HttpURLConnection
                    connection.requestMethod = "POST"
//                    connection.setRequestProperty("Content-Type", "application/json")
//                    connection.doOutput = true

                    val requestBody = """
                    {
                        "workSpaceURL":"$workPlaceDomain",
                        "companyName": "$workPlaceName",
                        "companyEmail": "$workPlaceEmail",
                        "companyPassword": "$workPlacePswd"
                    }""".trimIndent()
                    connection.outputStream.use { it.write(requestBody.toByteArray()) }
                    connection.inputStream.bufferedReader().use { it.readText() }
                }
                println("Register Log KK Response: $response")
            } catch (e: Exception) {
                println("Register Log KK Error: ${e.message}")
            }
        }

//        return isAvail;
    }

}