package com.shahryar.daybar

import android.content.Context
import android.os.Build
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
    var fontPath = attributes!!.getResourceId(R.styleable.DayBar_font, R.font.roboto_regular)

    init {
        setAttrs()
    }

    private fun setAttrs() {
        //Assign text color when selected and not selected
        if (isSelected) setTextColor(attributes?.getColor(R.styleable.DayBar_textColorSelected, 0)!!)
        else setTextColor(attributes?.getColor(R.styleable.DayBar_android_textColor, 0)!!)
        //Apply font
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            typeface = context.resources.getFont(fontPath)
        }
        //TODO:Show task indicator when filled with tasks

    }
    
}