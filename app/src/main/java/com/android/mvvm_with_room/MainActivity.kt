package com.android.mvvm_with_room

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mvvm_with_room.adapter.MainAdapter
import com.android.mvvm_with_room.data.UserDatabase
import com.android.mvvm_with_room.data.UserEntity
import com.android.mvvm_with_room.databinding.ActivityMainBinding
import com.android.mvvm_with_room.viewmodel.MainViewModel
import com.android.mvvm_with_room.viewmodel.MainViewModel.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    private val userDao = UserDatabase.getInstance().userDao()
    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = mainAdapter
        }

        initListener()

        binding.add.setOnClickListener { clickAction(EventType.ADD) }
        binding.delete.setOnClickListener { clickAction(EventType.DELETE) }
        binding.update.setOnClickListener { clickAction(EventType.UPDATE) }
        binding.clear.setOnClickListener { clickAction(EventType.CLEAR_ALL) }
        binding.getAll.setOnClickListener { clickAction(EventType.GET_ALL) }
    }

    private fun clickAction(type: EventType) {
        val name = binding.inputName.text.toString()
        val age = binding.inputAge.text.toString()
        viewModel.dbAction(
            type,
            userDao,
            UserEntity(
                if (!TextUtils.isEmpty(name)) name else "Null",
                if (!TextUtils.isEmpty(age)) age.toInt() else 0
            )
        )
    }

    private fun initListener() {
        viewModel.userList.observe(this, {
            mainAdapter.setList(it)
        })
    }
}