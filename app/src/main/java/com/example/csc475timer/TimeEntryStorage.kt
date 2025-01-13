package com.example.csc475timer

import android.content.Context
import com.google.gson.Gson
import java.io.File
import java.sql.Time

// Class that defines the storage for the time entries for the app
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

    private fun loadEntries(): List<TimeEntry> {
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

    // Function that gets the sum of the durations of all entries for a particular day
    fun getEntrySumByDate(date: Long): Long {
        val entries = loadEntries()
        var sum: Long = 0
        for (entry in entries) {
            if (entry.startTime >= date && entry.endTime <= date) {
                sum += entry.getDuration().toLong()
            }
        }
        return sum
    }

    // Function that gets the sum of the durations of all entries for a particular week
    fun getEntrySumByWeek(date: Long): Long {
        val entries = loadEntries()
        var sum: Long = 0
        for (entry in entries) {
            if (entry.startTime >= date - 604800000 && entry.endTime <= date) {
                sum += entry.getDuration().toLong()
            }
        }
        return sum
    }

    // Function that gets the sum of the durations of all entries for a particular month
    fun getEntrySumByMonth(date: Long): Long {
        val entries = loadEntries()
        var sum: Long = 0
        for (entry in entries) {
            if (entry.startTime >= date - 2629746000 && entry.endTime <= date) {
                sum += entry.getDuration().toLong()
            }
        }
        return sum
    }

    // Function that gets the sum of the durations of all entries for a particular year
    fun getEntrySumByYear(date: Long): Long {
        val entries = loadEntries()
        var sum: Long = 0
        for (entry in entries) {
            if (entry.startTime >= date - 31556952000 && entry.endTime <= date) {
                sum += entry.getDuration().toLong()
            }
        }
        return sum
    }

    // Function that gets the sum of the durations of all entries for a particular date range
    fun getEntrySumByDateRange(startDate: Long, endDate: Long): Long {
        val entries = loadEntries()
        var sum: Long = 0
        for (entry in entries) {
            if (entry.startTime >= startDate && entry.endTime <= endDate) {
                sum += entry.getDuration().toLong()
            }
        }
        return sum
    }
}