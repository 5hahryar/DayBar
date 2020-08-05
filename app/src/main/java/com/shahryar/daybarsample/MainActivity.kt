package com.shahryar.daybarsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shahryar.daybar.DayBar
import com.shahryar.daybar.DayBarChip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DayBar.OnDayChangedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dayBar = dayBar
        dayBar.dayChangedListener = this


    }

    override fun onSelectedDayChanged(date: HashMap<String, String>, chip: DayBarChip) {
        Toast.makeText(this, "${chip.isChecked}\n${date.toString()}", Toast.LENGTH_LONG).show()
    }
}