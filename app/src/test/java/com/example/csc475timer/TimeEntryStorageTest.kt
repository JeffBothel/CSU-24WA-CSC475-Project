package com.example.csc475timer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TimeEntryStorageTest {

    @Test
    fun getEntryCount() {
        var testTimeEntryStorage: TimeEntryStorage = TimeEntryStorage(testTimeEntryStorage)
        testTimeEntryStorage.saveEntry(TimeEntry(1, "Test Entry 1", 0, 1000, false))
        testTimeEntryStorage.saveEntry(TimeEntry(2, "Test Entry 2", 0, 1000, false))
        testTimeEntryStorage.saveEntry(TimeEntry(3, "Test Entry 3", 0, 1000, false))
        testTimeEntryStorage.saveEntry(TimeEntry(4, "Test Entry 4", 0, 1000, false))
        assertEquals(4, testTimeEntryStorage.getEntryCount())
    }

    @Test
    fun getEntrySumByDate() {
        var testTimeEntryStorage: TimeEntryStorage = TimeEntryStorage(testTimeEntryStorage)
        testTimeEntryStorage.saveEntry(TimeEntry(1, "Test Entry 1", 0, 1000, false))
        testTimeEntryStorage.saveEntry(TimeEntry(2, "Test Entry 2", 0, 1000, false))
        testTimeEntryStorage.saveEntry(TimeEntry(3, "Test Entry 3", 0, 1000, false))
        testTimeEntryStorage.saveEntry(TimeEntry(4, "Test Entry 4", 0, 1000, false))
        assertEquals(4000, testTimeEntryStorage.getEntrySumByDate(0))
    }

    @Test
    fun getEntrySumByWeek() {

    }

    @Test
    fun getEntrySumByMonth() {
    }

    @Test
    fun getEntrySumByYear() {
    }

    @Test
    fun getEntrySumByDateRange() {
    }
}