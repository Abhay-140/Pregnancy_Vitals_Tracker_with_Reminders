package com.pregnancyvitalstrackerwithreminders.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VitalsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVitals(vitals: VitalsEntity)

    @Query("SELECT * FROM vitals ORDER BY timestamp DESC")
    fun getAllVitals(): LiveData<List<VitalsEntity>>
}
