package com.saman.aparat.customView

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import android.graphics.Typeface
import android.util.AttributeSet

class customView2 : AppCompatTextView {
    private fun extracted(context: Context) {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/IRANSans_Medium.ttf")
        setTypeface(typeface)
    }

    constructor(context: Context) : super(context) {
        extracted(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        extracted(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        extracted(context)
    }
}