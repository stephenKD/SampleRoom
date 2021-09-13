package com.android.mvvm_with_room.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

//    @Delete
//    suspend fun delete(user:UserEntity)

    @Query("delete from user where userName = :name")
    suspend fun delete(name: String)

//    @Update
//    suspend fun update(user:UserEntity)

    @Query("update user set userAge = :age where userName = :name")
    suspend fun update(name: String, age: Int)

    @Query("select * from user")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("delete from user")
    suspend fun clearAll()

}