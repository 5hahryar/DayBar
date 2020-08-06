package com.shahryar.daybar

import android.content.Context
import android.util.AttributeSet

class DayBarChip(
    context: Context?,
    attrs: AttributeSet
) : androidx.appcompat.widget.AppCompatToggleButton(context, attrs) {

    /**
     * Using constant values to help maintain consistency
     */
    companion object {
        const val DAY_NAME = "EEE"
        const val DAY = "dd"
        const val MONTH_NAME = "MMM"
        const val MONTH = "MM"
        const val YEAR = "yyyy"
    }

    /**
     * Setting chip's custom date and text value
     */
    var date: HashMap<String, String> = hashMapOf()
        set(date) {
            field = date
            textOn = "${date[DAY]}\n${date[DAY_NAME]}"
            textOff = "${date[DAY]}\n${date[DAY_NAME]}"
        }

    val attributes = context?.obtainStyledAttributes(attrs, R.styleable.DayBar)

    init {
        setAttrs()
    }

    private fun setAttrs() {
        if (isSelected) setTextColor(attributes?.getColor(R.styleable.DayBar_textColorSelected, 0)!!)
        else setTextColor(attributes?.getColor(R.styleable.DayBar_android_textColor, 0)!!)
    }
    
}