package com.example.csc475timer

data class TimeEntry(
    val id: Int,
    val description: String,
    val startTime: Long,
    val endTime: Long,
    val isWorkRelated: Boolean
) {
    fun getDuration(): Long {
        return endTime - startTime
    }
}