package com.example.smarthabittracker

import android.content.Context
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
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
        Gson().fromJson(file.readText(), object : com.google.gson.reflect.TypeToken<List<Habit>>() {}.type)
    } else {
        emptyList()
    }
}