package com.android.mvvm_with_room.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.mvvm_with_room.base.AppApplication

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: UserDatabase? = null
        fun getInstance(): UserDatabase {
            return instance ?: AppApplication.getAppContext().let {
                Room.databaseBuilder(it, UserDatabase::class.java, "user.db").build()
            }.also {
                instance = it
            }
        }
    }
}