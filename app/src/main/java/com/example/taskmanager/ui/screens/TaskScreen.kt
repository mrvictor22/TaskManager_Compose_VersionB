package com.example.taskmanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskmanager.ui.TaskViewModel
import com.example.taskmanager.ui.components.TaskInput
import com.example.taskmanager.ui.components.TaskItem

import androidx.compose.material3.HorizontalDivider
import com.example.taskmanager.ui.components.FilterChips
import com.example.taskmanager.ui.TaskFilter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(vm: TaskViewModel) {
    val state by vm.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Task Manager (Compose)") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Entrada para añadir nuevas tareas
            TaskInput(onAdd = vm::addTask)
            FilterChips(
                selected = state.filter,
                onSelect = vm::setFilter
            )
            HorizontalDivider()

            // Lista de tareas (por ahora sin filtros: todas)
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(state.visible, key = { it.id }) { task ->
                    TaskItem(
                        task = task,
                        onToggle = vm::toggleTask,
                        onDelete = vm::deleteTask
                    )
                }
            }
        }
    }
}
