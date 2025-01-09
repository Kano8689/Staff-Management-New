package com.example.staffmanagement

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

enum class MonthName(val start: Int) {
    January(0),
    February(1),
    March(2),
    April(3),
    May(4),
    June(5),
    July(6),
    August(7),
    September(8),
    October(9),
    November(10),
    December(11);

    fun getMonthNumber(month:Int): Int {
        return start
    }
}


class ProjectTask : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_project_task)

        var addTaskBtn:Button = findViewById(R.id.add_task_btn)
        addTaskBtn.setBackgroundResource(R.drawable.add_task)

        var backBtn: ImageButton = findViewById(R.id.backButton)
        backBtn.setOnClickListener{
            this.startActivity(Intent(this,DashboardMain::class.java))
        }

        val date: TextView = findViewById(R.id.date)
        val day:TextView = findViewById(R.id.day)

        val currentDate = LocalDate.now()
        date.text = "${currentDate.dayOfMonth},${getMonthName(currentDate.monthValue)} ${currentDate.year}"
        day.text = getDayName(currentDate.dayOfMonth, currentDate.monthValue, currentDate.year)

        val calendarView: CalendarView = findViewById(R.id.calendarView)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val dayName = getDayName(dayOfMonth, month+1, year)
            val selectedDate = "$dayOfMonth,${getMonthName(month+1)} $year"
            date.text = selectedDate
            day.text = dayName
        }
    }
    fun getMonthName(index: Int): MonthName? {
        return if (index in 1..12) MonthName.values()[index - 1] else null
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getDayName(day: Int, month: Int, year: Int): String {
        val date = LocalDate.of(year, month, day)
        val dayOfWeek = date.dayOfWeek
        return dayOfWeek.name.lowercase().replaceFirstChar { it.uppercase() }
    }
}