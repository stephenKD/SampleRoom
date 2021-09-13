package com.android.mvvm_with_room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mvvm_with_room.data.UserDao
import com.android.mvvm_with_room.data.UserDatabase
import com.android.mvvm_with_room.data.UserEntity
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var userList = UserDatabase.getInstance().userDao().getAll()

    fun dbAction(type: EventType, userDao: UserDao, userEntity: UserEntity) {
        viewModelScope.launch {
            when (type) {
                EventType.ADD -> userDao.insert(userEntity)
                EventType.DELETE -> userDao.delete(userEntity.name)
                EventType.UPDATE -> userDao.update(userEntity.name, userEntity.age)
                EventType.CLEAR_ALL -> userDao.clearAll()
            }
            UserDatabase.getInstance().userDao().getAll()
        }
    }

    enum class EventType {
        ADD, DELETE, UPDATE, CLEAR_ALL, GET_ALL
    }
}