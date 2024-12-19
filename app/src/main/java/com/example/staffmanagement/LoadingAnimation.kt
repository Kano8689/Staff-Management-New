package com.example.staffmanagement

import android.content.Context
import android.content.Intent
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class LoadingAnimation(
    var _context:Context,
    var _progress:ProgressBar,
    var _textView:TextView,
    var _from: Float,
    var _to: Float
) :Animation() {
    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
        var _value = _from + (_to - _from) * interpolatedTime
        _progress.progress = _value.toInt()
        _textView.text = "Loading.. ${_value.toInt()} %"

        if(_value==_to)
        {
            _context.startActivity(Intent(_context,Login::class.java))
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