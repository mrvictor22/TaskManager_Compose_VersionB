package com.example.taskmanager.data

import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val isDone: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
