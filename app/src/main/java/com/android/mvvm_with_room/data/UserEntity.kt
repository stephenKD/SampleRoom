package com.android.mvvm_with_room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USER")
class UserEntity(
    @ColumnInfo(name = "UserName")
    var name: String,
    @ColumnInfo(name = "UserAge")
    var age: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}