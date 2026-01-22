package com.pregnancyvitalstrackerwithreminders.data

import androidx.lifecycle.LiveData

class VitalsRepository(private val dao: VitalsDao) {

    val allVitals: LiveData<List<VitalsEntity>> = dao.getAllVitals()

    suspend fun insert(vitals: VitalsEntity) {
        dao.insertVitals(vitals)
    }
}
