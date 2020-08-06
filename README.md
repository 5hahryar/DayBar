[![](https://jitpack.io/v/5hahryar/DayBar.svg)](https://jitpack.io/#5hahryar/DayBar)
# DayBar

Display weekdays and choose a day using DayBar.

![alt text](https://github.com/5hahryar/DayBar/blob/master/Screenshot.png?raw=true)

## Installation

1.Add jitpack repository to your project's build.gradle(Project:...)
```bash
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
  ```
2.Add the dependency in build.gradle(Module:app)
```bash
implementation 'com.github.5hahryar:DayBar:1.0.0'
```

## Usage

### In your layout file
```bash
<com.shahryar.daybar.DayBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```
### In your activity
```bash 
class MainActivity : AppCompatActivity(), DayBar.OnDayChangedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
	
        val dayBar: DayBar = dayBar
        dayBar.dayChangedListener = this
    }

    override fun onSelectedDayChanged(date: HashMap<String, String>, chip: DayBarChip) {
        //Do something
    }

}
```

### Support
Reach out to me at shahryar.kh78@gmail.com
Feel free to make any contributations.
