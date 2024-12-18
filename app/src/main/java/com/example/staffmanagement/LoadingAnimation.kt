package com.example.staffmanagement

import android.content.Context
import android.content.Intent
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar
import android.widget.TextView

class LoadingAnimation(
    var _context:Context,
    var _progress:ProgressBar,
    var _textView:TextView,
    var _from: Float,
    var _to: Float
) :Animation()

{
    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
        var _value = _from + (_to - _from) * interpolatedTime
        _progress.progress = _value.toInt()
        _textView.text = "Loading.. ${_value.toInt()} %"

        if(_value==_to)
        {
            _context.startActivity(Intent(_context,Dashboard::class.java))
        }


    }
}