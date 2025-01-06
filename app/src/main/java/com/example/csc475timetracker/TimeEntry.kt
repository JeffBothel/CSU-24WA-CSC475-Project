package com.example.csc475timetracker

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "time_entries")
data class TimeEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val description: String,
    val startTime: Long,
    val endTime: Long,
    val isWorkRelated: Boolean
)