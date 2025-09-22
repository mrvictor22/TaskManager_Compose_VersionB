
---


# 📋 Task Manager — Jetpack Compose (Versión B)

Este proyecto corresponde a la **versión en Jetpack Compose** de la aplicación **Task Manager**, desarrollada como parte de la asignación de Android Studio.  
El objetivo principal es comparar dos enfoques de UI en Android:
- **Versión A:** XML + Layout tradicional
- **Versión B:** Jetpack Compose (este repositorio)

---

## 🚀 Funcionalidades

- ➕ Agregar nuevas tareas con campo de entrada.
- ✅ Marcar y desmarcar tareas como completadas.
- 🗑️ Eliminar tareas de la lista.
- 🔎 Filtros dinámicos:
  - **All** → Todas las tareas.
  - **Active** → Solo pendientes.
  - **Done** → Solo completadas.
- 🎨 Interfaz moderna con **Material Design 3 (Compose)**.

---

## 🛠️ Tecnologías y librerías usadas

- [Kotlin](https://kotlinlang.org/)  
- [Jetpack Compose](https://developer.android.com/jetpack/compose)  
- [Material Design 3](https://m3.material.io/)  
- **StateFlow** + **ViewModel** para la gestión de estado reactivo.

---

## 📂 Estructura del Proyecto

```

app/
└─ src/main/java/com/example/taskmanager
├─ data/               # Modelo y repositorio en memoria
│   ├─ Task.kt
│   └─ TaskRepository.kt
├─ ui/
│   ├─ TaskViewModel.kt
│   ├─ components/     # Componentes reutilizables
│   │   ├─ TaskInput.kt
│   │   ├─ TaskItem.kt
│   │   └─ FilterChips.kt
│   └─ screens/        # Pantallas completas
│       └─ TaskScreen.kt
└─ MainActivity.kt     # Punto de entrada

````

---

## ▶️ Ejecución

1. Clonar el repositorio:
   ```
   git clone https://github.com/tu-usuario/TaskManager_Compose_VersionB.git
`

2. Abrir el proyecto en **Android Studio** (versión recomendada: Giraffe o superior).
3. Sincronizar Gradle y ejecutar en un emulador o dispositivo físico.

---

## 📹 Video de Demostración

En el video final del equipo se mostrará:

* La versión **XML (A)** y la versión **Compose (B)**.
* Comparativa técnica, ventajas y desventajas.

👉 \[Enlace al video pronto aquí]

---

## 👥 Integrantes - Grupo 5

---

