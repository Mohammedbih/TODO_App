package com.example.todoapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.adapters.ClickListener
import com.example.todoapp.adapters.CustomAdapter
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.model.TaskViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)


        binding.taskViewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = CustomAdapter(ClickListener { task ->
            viewModel.delete(task)
        })

        binding.recycleView.adapter = adapter

    }
}