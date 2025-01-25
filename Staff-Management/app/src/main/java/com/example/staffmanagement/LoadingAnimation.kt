package com.example.staffmanagement

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.staffmanagement.MainActivity.PrefrenceDataObject._PrefrenceData

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

class LoadingAnimation(
    var _context:MainActivity,
    var _progress:ProgressBar,
    var _textView:TextView,
    var _from: Float,
    var _to: Float
) :Animation() {
    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
        var _value = _from + (_to - _from) * interpolatedTime
        _progress.progress = _value.toInt()
        _textView.text = "Loading.. ${_value.toInt()}%"

        if(_value==_to)
        {
            Log.d("Open Screen from Splash", "11-isLogin: "+(_PrefrenceData.getBoolean("isLogin",false)))

                _context.OpenActivity(_PrefrenceData.getBoolean("isLogin",false))
        }
    }
}


class LoadingImage(
    var _logo:ImageView,
    var _fromAlpha:Float,
    var _toAlpha:Float,
    var _fromScale:Float,
    var _toScale:Float,
    var _fromRotate:Int,
    var _toRotate:Int
) :Animation(){
    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
        var _valueAlpha = _fromAlpha + (_toAlpha - _fromAlpha) * interpolatedTime
        var _valueScale = _fromScale + (_toScale - _fromScale) * interpolatedTime
        _logo.alpha = _valueAlpha.toFloat()
        _logo.scaleX = _valueScale.toFloat()
        _logo.scaleY = _valueScale.toFloat()

        if(_valueScale == _toScale)
        {
            var _valueRotate = _fromRotate + (_toRotate - _fromRotate) * interpolatedTime
            _logo.rotationY = _valueRotate
        }
    }
}