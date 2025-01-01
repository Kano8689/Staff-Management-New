package com.example.staffmanagement

import CustomTypefaceSpan
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat


class DashboardMain : AppCompatActivity() {

    lateinit var gridView:GridView

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

        //options Grid View Image Button
        gridView = findViewById<GridView>(R.id.opt_items)
        val optionsAdapter = OptionsAdapter(this)
        gridView.adapter = optionsAdapter


        //profile picture
        val profilePic = findViewById<ImageButton>(R.id.profile_pic)
        profilePic.setOnClickListener{
            Toast.makeText(this,"Clicked on: Profile Picture",Toast.LENGTH_SHORT).show()
        }

        val employeeName: TextView = findViewById(R.id.employee_name)
        val name = "KASHMIRA BAVADIYA"
        val role = "(UI/UX Designer)"
        val fullText = "$name\n$role"

        val spannable = SpannableString(fullText)

        val nameFont = ResourcesCompat.getFont(this, R.font.poppins_black)
        val roleFont = ResourcesCompat.getFont(this, R.font.poppins_bolditalic)

        // Apply spans
        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#FFFFFF")),
            0,
            name.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        if (nameFont != null) {
            spannable.setSpan(
                CustomTypefaceSpan(nameFont),
                0,
                name.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#C8C8C8")),
            name.length,
            fullText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        if (roleFont != null) {
            spannable.setSpan(
                CustomTypefaceSpan(roleFont),
                name.length,
                fullText.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        employeeName.text = spannable
    }
}