package com.example.todoapp.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.Task

@BindingAdapter("app:bindList")
fun RecyclerView.bindList(listData: List<Task>) {
    val adapter = adapter as CustomAdapter
    adapter.submitList(listData)
}