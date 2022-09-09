package com.example.todoapp.data

import androidx.room.*

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getAllTasks(): List<Task>
}