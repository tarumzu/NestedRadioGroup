# NestedRadioGroup
RadioGroup that allows you to nest RadioButton in a ViewGroup.


## Gradle dependency 
```
allprojects {
  repositories {
    jcenter()
  }
}
```
    
```
implementation 'com.tarumzu.nestedradiogroup:nested-radio-group:1.0.1'
```

## How to use

### Basic example

- activity_main.xml

```xml
    <com.tarumzu.nestedradiogroup.NestedRadioGroup
        android:id="@+id/radiogroup"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="@id/hello"
        >
        <RadioButton
            android:id="@+id/radio1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_constraintBottom_toTopOf="@id/radio2_layout"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            android:text="radio1" />
        <androidx.constraintlayout.widget.ConstraintLayout
            android:id="@+id/radio2_layout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            >
            <RadioButton
                android:id="@+id/radio2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                android:text="radio2"
                />
        </androidx.constraintlayout.widget.ConstraintLayout>
    </com.tarumzu.nestedradiogroup.NestedRadioGroup>
```

- MainActivity.kt

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
    // onClick
    radiogroup.setOnClickListener(object : NestedRadioGroup.OnClickListener {
        override fun onClick(var1: View?) {
            when (var1?.id) {
                R.id.radio1 -> {
                    // radio1
                }
                R.id.radio2 -> {
                    // radio2
                }
            }
        }

    }
    
    // onCheckedChanged
    radiogroup.setOnCheckedChangeListener(object : NestedRadioGroup.OnCheckedChangeListener {
        override fun onCheckedChanged(var1: MutableMap<Int, RadioButton>, var2: Int) {
            when (var2) {
                R.id.radio1 -> {
                    // radio1
                }
                R.id.radio2 -> {
                    // radio2
                }
            }
        }

    }
}
```

### Java samples: [here](app/src/main/)

### Min SDK 21

### License 
Apache 2.0

### Author
Wataru Mizukami
