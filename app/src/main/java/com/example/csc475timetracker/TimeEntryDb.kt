package com.example.csc475timetracker

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TimeEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun timeEntryDao(): TimeEntryDao
}