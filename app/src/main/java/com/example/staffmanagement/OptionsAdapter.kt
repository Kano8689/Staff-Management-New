package com.example.staffmanagement

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.Toast

class OptionsAdapter (val context: Context) :BaseAdapter()
{
    val activityOpen = arrayOf("ProjectTask", "TaskDone", "Attendance", "Leaves", "SalaryDetails", "Team")

    private val images = intArrayOf(
        R.drawable.dash_opt_project_task,
        R.drawable.dash_opt_task_done,
        R.drawable.dash_opt_attendence,
        R.drawable.dash_opt_leave,
        R.drawable.dash_opt_salary_detail,
        R.drawable.dash_opt_team
    )
    private val labels = arrayOf(
        "Project Task",
        "Task Done",
        "Attendance",
        "Leave",
        "Salary Detail",
        "Team"
    )


    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var gridView:View? = convertView
        if(gridView == null)
        {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            gridView = inflater.inflate(R.layout.options_item, parent, null == true)
        }

        val optBtn = gridView?.findViewById<ImageButton>(R.id.opt_btn)
        optBtn?.setImageResource(images[position])

        optBtn?.setOnClickListener{
            when (position) {
                0 -> context.startActivity(Intent(context, ProjectTask::class.java))
                1 -> context.startActivity(Intent(context, TaskDone::class.java))
                2 -> context.startActivity(Intent(context, Attedence::class.java))
                3 -> context.startActivity(Intent(context, Leaves::class.java))
                4 -> context.startActivity(Intent(context, SalaryDetails::class.java))
                5 -> context.startActivity(Intent(context, Team::class.java))
            }
            Toast.makeText(context,"Clicked on: ${labels[position]} Option",Toast.LENGTH_SHORT).show()
        }

        return gridView
    }
}