package com.example.csc475timer

import android.content.Context
import com.google.gson.Gson
import java.io.File
import java.sql.Time

class TimeEntryStorage(private val context: Context) {
    private val gson = Gson()
    private val fileName = "entries.json"
    private val sharedPreferences = context.getSharedPreferences("entry_prefs", Context.MODE_PRIVATE)

    fun saveEntry(entry: TimeEntry) {
        val entries = loadEntries().toMutableList()
        entries.add(entry)
        val jsonString = gson.toJson(entries)
        context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(jsonString.toByteArray())
        }
        incrementEntryCount()
    }

    fun loadEntries(): List<TimeEntry> {
        return try {
            val file = File(context.filesDir, fileName)
            if (file.exists()) {
                val jsonString = file.readText()
                gson.fromJson(jsonString, Array<TimeEntry>::class.java).toList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    private fun incrementEntryCount() {
        val count = sharedPreferences.getInt("entry_count", 0) + 1
        sharedPreferences.edit().putInt("entry_count", count).apply()
    }

    fun getEntryCount(): Int {
        return sharedPreferences.getInt("entry_count", 0)
    }
}