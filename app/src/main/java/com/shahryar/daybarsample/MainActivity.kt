package com.shahryar.daybarsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.shahryar.daybar.DayBar
import com.shahryar.daybar.DayBarChip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var dayBar: DayBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dayBar = findViewById(R.id.dayBar)
        dayBar?.setIndicationByIndex(listOf(2, 6))
        dayBar?.setOnDayChangedListener(object: DayBar.OnDayChangedListener {
            override fun onSelectedDayChanged(
                index: Int,
                date: HashMap<String, String>,
                chip: DayBarChip
            ) {
                textView.text = "${chip.isChecked}\n${date} \t Index: $index"
            }
        })
    }

    fun onClick(view: View) {
        Toast.makeText(this, dayBar?.getSelectedDay()?.date.toString(), Toast.LENGTH_LONG).show()
    }

}
