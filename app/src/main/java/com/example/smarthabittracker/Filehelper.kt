package com.example.smarthabittracker

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

fun saveHabitsToFile(context: Context, habits: List<Habit>) {
    val file = File(context.filesDir, "habits.txt")
    file.writeText(Gson().toJson(habits))
}

fun loadHabitsFromFile(context: Context): List<Habit> {
    val file = File(context.filesDir, "habits.txt")
    return if (file.exists()) {
        Gson().fromJson(file.readText(), object : TypeToken<List<Habit>>() {}.type)
    } else {
        emptyList()
    }
}