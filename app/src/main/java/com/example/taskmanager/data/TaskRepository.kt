package com.example.taskmanager.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TaskRepository {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    fun add(title: String) {
        if (title.isBlank()) return
        _tasks.update { it + Task(title = title.trim()) }
    }

    fun toggle(id: String) {
        _tasks.update { list ->
            list.map { if (it.id == id) it.copy(isDone = !it.isDone) else it }
        }
    }

    fun remove(id: String) {
        _tasks.update { it.filterNot { t -> t.id == id } }
    }
}
