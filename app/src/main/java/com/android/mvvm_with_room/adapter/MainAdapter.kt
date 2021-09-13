package com.android.mvvm_with_room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mvvm_with_room.data.UserEntity
import com.android.mvvm_with_room.databinding.ItemViewBinding

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var mList: MutableList<UserEntity> = mutableListOf()

    fun setList(list: List<UserEntity>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}

class MainViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(userEntity: UserEntity) {
        binding.name.text = userEntity.name
        binding.age.text = userEntity.age.toString()
    }
}