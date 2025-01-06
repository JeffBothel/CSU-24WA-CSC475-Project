package com.example.csc475timetracker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TimeEntryDao {
    @Insert
    suspend fun insert(timeEntry: TimeEntry)

    @Query("SELECT * FROM time_entries")
    suspend fun getAll(): List<TimeEntry>
}