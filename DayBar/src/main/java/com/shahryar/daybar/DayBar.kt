package com.shahryar.daybar

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.day_bar_layout.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class DayBar(context: Context?, attrs: AttributeSet) : LinearLayout(context, attrs) {

    /**
     * Setting chip's custom date and text value
     */
    private val dayChips: MutableList<DayBarChip>
    private var dayChangedListener: OnDayChangedListener? = null
    private val attributes = context?.obtainStyledAttributes(attrs, R.styleable.DayBar)

    init {
        inflate(context, R.layout.day_bar_layout, this)
        dayChips = mutableListOf(chip0, chip1, chip2, chip3, chip4, chip5, chip6)
        setAttrs()
        setListeners()
        assignDateToChips(Calendar.getInstance())
        dayChips[0].performClick()
    }

    /**
     * Assign date values to chips
     */
    private fun assignDateToChips(calendar: Calendar) {
        //Assign date to chips
        for (i in 0..6) {
            if (i != 0) calendar.add(Calendar.DAY_OF_WEEK, 1)
            val date: HashMap<String, String> = hashMapOf(
                DayBarChip.DAY to SimpleDateFormat(DayBarChip.DAY)
                    .format(calendar.time).toString(),
                DayBarChip.DAY_NAME to SimpleDateFormat(DayBarChip.DAY_NAME)
                    .format(calendar.time).toString(),
                DayBarChip.MONTH to SimpleDateFormat(DayBarChip.MONTH)
                    .format(calendar.time).toString(),
                DayBarChip.MONTH_NAME to SimpleDateFormat(DayBarChip.MONTH_NAME)
                    .format(calendar.time).toString(),
                DayBarChip.YEAR to SimpleDateFormat(DayBarChip.YEAR)
                    .format(calendar.time).toString()
            )
            dayChips[i].date = date
        }
    }

    private fun setListeners() {
        //Making sure only one chip is selected at all times
        for (chip in dayChips) {
            chip.setOnClickListener { view: View? ->
                val c = view as DayBarChip
                if (c.isChecked) {
                    for (i in 0..6) {
                        dayChips[i].isChecked = dayChips[i].id == c.id
                        if (dayChips[i].isChecked) c.setTextColor(resources.getColor(R.color.day_bar_chip_text_color_selected))
                        else dayChips[i].setTextColor(resources.getColor(R.color.day_bar_chip_text_color))
                    }
                } else c.isChecked = true

                var index = 0
                for (i in 0..6) {
                    if (dayChips[i].isChecked) index = i
                }
                dayChangedListener?.onSelectedDayChanged(index, c.date, c)
            }
        }
    }

    /**
     * Setting attributes to both DayBar and DayBarChip
     */
    private fun setAttrs() {
        //Typeface for darBarChip
        for (chip in dayChips) {
            var fontPath =attributes?.getResourceId(R.styleable.DayBar_font, R.font.roboto_regular)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                chip.typeface = context.resources.getFont(fontPath!!)
            }
        }
    }

    /**
     * Enable indication by passing desired indices
     * ranging from 0 to 6
     */
    fun setIndicationByIndex(list: List<Int>) {
        for (index in list) {
            dayChips[index].hasIndication = true
        }
    }

    /**
     * Enable indication by passing desired days
     * ranging from 1 to 31 depending on time
     */
    fun setIndicationByDay(days: List<Int>) {
        for (day in days) {
            for (chip in dayChips) {
                if (chip.date[DayBarChip.DAY]!!.toInt() == day)
                    chip.hasIndication = true
            }
        }
    }

    fun getSelectedDay(): DayBarChip? {
        for (day in dayChips) {
            if (day.isChecked) return day
        }
        return null
    }

    fun setOnDayChangedListener(listener: OnDayChangedListener) {
        dayChangedListener = listener
    }

    interface OnDayChangedListener {
        fun onSelectedDayChanged(index: Int, date: HashMap<String, String>, chip: DayBarChip)
    }

}