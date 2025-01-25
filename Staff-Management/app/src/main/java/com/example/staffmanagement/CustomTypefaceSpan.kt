import android.graphics.Paint
import android.text.TextPaint
import android.text.style.TypefaceSpan
import android.graphics.Typeface

class CustomTypefaceSpan(private val customTypeface: Typeface) : TypefaceSpan("") {

    override fun updateDrawState(ds: TextPaint) {
        applyCustomTypeFace(ds, customTypeface)
    }

    override fun updateMeasureState(paint: TextPaint) {
        applyCustomTypeFace(paint, customTypeface)
    }

    private fun applyCustomTypeFace(paint: Paint, typeface: Typeface) {
        paint.typeface = typeface
    }
}
