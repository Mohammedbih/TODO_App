package com.example.todoapp.repo

import com.example.todoapp.data.Task
import com.example.todoapp.data.TaskDao
import com.example.todoapp.data.TaskDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskRepository(private val dao: TaskDao = TaskDatabase.INSTANCE!!.taskDao) {

    suspend fun add(name: String) { withContext(Dispatchers.IO) { dao.add(Task(taskName = name)) } }

    suspend fun delete(task: Task) { withContext(Dispatchers.IO) { dao.delete(task) } }

    suspend fun getTasks(): List<Task> { return withContext(Dispatchers.IO) { dao.getAllTasks() } }
}