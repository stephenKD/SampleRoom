# SampleRoom
Kotlin practice, Room practice with MVVM.

<img src="https://github.com/stephenKD/SampleRoom/blob/master/app/src/main/res/drawable/sample_pic.png?raw=true" width=20% height=20%/>

## Step 1
Add libs in "build.gradle".
```
plugins {
    id 'kotlin-kapt'
}

buildFeatures{
    viewBinding true
}

def room_version = "2.3.0"
//Room
implementation "androidx.room:room-runtime:$room_version"
implementation "androidx.room:room-ktx:$room_version"
kapt "androidx.room:room-compiler:$room_version"

//coroutine
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1'
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1'

//Kotlin activity ktx
implementation "androidx.activity:activity-ktx:1.3.1"

```

## Step 2
Start practice.
