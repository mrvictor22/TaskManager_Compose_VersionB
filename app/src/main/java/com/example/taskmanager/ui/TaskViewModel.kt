package com.example.taskmanager.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanager.data.Task
import com.example.taskmanager.data.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

enum class TaskFilter { ALL, ACTIVE, DONE }

data class TaskUiState(
    val items: List<Task> = emptyList(),
    val filter: TaskFilter = TaskFilter.ALL
) {
    val visible: List<Task>
        get() = when (filter) {
            TaskFilter.ALL -> items
            TaskFilter.ACTIVE -> items.filter { !it.isDone }
            TaskFilter.DONE -> items.filter { it.isDone }
        }
}

class TaskViewModel(
    private val repo: TaskRepository = TaskRepository()
) : ViewModel() {

    private val selectedFilter = MutableStateFlow(TaskFilter.ALL)

    val uiState: StateFlow<TaskUiState> = combine(
        repo.tasks, selectedFilter
    ) { tasks, filter ->
        TaskUiState(items = tasks, filter = filter)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = TaskUiState()
    )

    fun addTask(title: String) = repo.add(title)
    fun toggleTask(id: String) = repo.toggle(id)
    fun deleteTask(id: String) = repo.remove(id)
    fun setFilter(f: TaskFilter) { selectedFilter.value = f }
}
