package com.example.staffmanagement

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataBaseManager (_Context: Context) : SQLiteOpenHelper(_Context,"staff_management",null,1){
    var _context = _Context
    @SuppressLint("Range")
    override fun onCreate(myDB: SQLiteDatabase?)
    {
        /*
            table create:
                - company register (work_place)

                - user details (employee_details)
                - create account of employee by admin
                - employee account details update by admin

                - project task (project_task)
                - project done (project_task (bool isDone))

                - salary details (salary_details)
                - team (team_members)

                - attendence (attendence)
                - leave (attedence (char [p,l,h,r]))

                - company details (company_details)
                - company details edit by admin
         */
        var workPlace = "CREATE TABLE work_place (id integer PRIMARY KEY AUTOINCREMENT, workplace_domain text, workplace_name text, workplace_email text, workplace_password text)"
        myDB?.execSQL(workPlace)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }


    fun RegisterCompny (workPlaceDomain:String,workPlaceName:String,workPlaceEmail:String,workPlacePassword:String) : Boolean {
        if(isAvailRecord4WorkPlaceRegister(workPlaceDomain, workPlaceName, workPlaceEmail))
        {
            Toast.makeText(_context,"You are already registered..",Toast.LENGTH_SHORT).show()
            return false
        }

        var myDB : SQLiteDatabase = writableDatabase
        var registerWorkPlace = "INSERT INTO work_place (workplace_domain,workplace_name,workplace_email,workplace_password) VALUES ('$workPlaceDomain','$workPlaceName','$workPlaceEmail','$workPlacePassword')"
        myDB.execSQL(registerWorkPlace)
        Toast.makeText(_context,"Successfully Registered..",Toast.LENGTH_SHORT).show()

        return true
    }
    fun isAvailRecord4WorkPlaceRegister (workPlaceDomain:String, workPlaceName:String, workPlaceEmail:String) : Boolean {
        var myDB : SQLiteDatabase = readableDatabase
        var select = "SELECT * FROM work_place WHERE workplace_domain = '$workPlaceDomain'  OR workplace_name = '$workPlaceName' OR workplace_email = '$workPlaceEmail'"
        return (myDB.rawQuery(select,null)).count>0;
    }


    fun SelectData4Login(workPlaceDomain:String, workPlaceName:String, userName:String, userPassword:String): Boolean {
        return (isAvailRecord4WorkPlaceLogin(userName,userPassword, workPlaceDomain))
    }
    fun isAvailRecord4WorkPlaceLogin (userName:String, userPasswod:String, workPlaceDomain:String) : Boolean {
        var myDB : SQLiteDatabase = readableDatabase
        var select = "SELECT * FROM work_place WHERE workplace_name = '$userName' AND workplace_password = '$userPasswod' AND workplace_domain = '$workPlaceDomain'"
        return (myDB.rawQuery(select,null)).count>0;
    }


}