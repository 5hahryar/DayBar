package com.shahryar.daybar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
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

    private val attributes = context?.obtainStyledAttributes(attrs, R.styleable.DayBar)!!
    private val indicatorPaint: Paint = Paint()
    private var isIndicated: Boolean = false
    var hasIndication: Boolean = false
    set(value) {
        field = value
        invalidate()
    }

    init {
        setAttrs()
    }

    private fun setAttrs() {
        //Assign text color when selected and not selected
        if (isSelected) setTextColor(attributes.getColor(R.styleable.DayBar_textColorSelected, 0))
        else setTextColor(attributes.getColor(R.styleable.DayBar_android_textColor, 0))
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
        //Show indicator when chip is not checked
        if (hasIndication && !isChecked) {
            indicatorPaint.color = context.resources.getColor(R.color.day_bar_chip_indicator_color)
            indicatorPaint.style = Paint.Style.FILL
            canvas?.drawCircle((width.toDouble()/2.00).toFloat(),height - 15F, 5F, indicatorPaint)
            isIndicated = true
        }
        else isIndicated = false
    }

    /**
     * Returns the state of indication
     */
    fun IsIndicated(): Boolean {return isIndicated}
}