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
implementation 'com.github.5hahryar:DayBar:Tag'
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
dayBar.setOnDayChangedListener(object: DayBar.OnDayChangedListener {
            override fun onSelectedDayChanged(date: HashMap<String, String>, chip: DayBarChip) {
                TODO("Do something")
            }
        })
```
## Customization
### Indication
Indicate chips by index
```bash
dayBar.setIndicationByIndex(listOf(2, 6))
```
Indicate chips by day
```bash
dayBar.setIndicationByDay(listOf(31, 3))
```
### Colors
Override colors in colors.xml
```bash
<color name="day_bar_chip_background_color">#6200EE</color>
    <color name="day_bar_chip_text_color_selected">#FFF</color>
    <color name="day_bar_chip_text_color">#6200EE</color>
    <color name="day_bar_chip_stroke_color">#6200EE</color>
```
### Font
First copy your .ttf file to font resource directory
```bash
<com.shahryar.daybar.DayBar
        ...
        app:font="@font/myfont_regular"/>
```

## Support
Reach out to me at shahryar.kh78@gmail.com

Feel free to make any contributions.
