package com.example.todoapp.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.Task
import com.example.todoapp.repo.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val repository = TaskRepository()

    private val _list = MutableLiveData(listOf(Task(taskName = "Done")))
    val list: LiveData<List<Task>> get() = _list

    var liveText = MutableLiveData("")

    init {
//        getTasksList()
    }

    fun add() {
        Log.i("TAG", "add: in")
        viewModelScope.launch {
            repository.add(liveText.value!!.apply {
                Log.i("TAG", "add: $this")
            })
        }
    }

    fun delete(task: Task) {
        viewModelScope.launch { repository.delete(task) }
    }

    private fun getTasksList() {
        viewModelScope.launch { _list.postValue(repository.getTasks()) }
    }
}