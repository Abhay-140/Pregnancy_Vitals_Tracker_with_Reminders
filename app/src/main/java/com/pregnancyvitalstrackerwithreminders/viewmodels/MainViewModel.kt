package com.pregnancyvitalstrackerwithreminders.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.pregnancyvitalstrackerwithreminders.data.AppDatabase
import com.pregnancyvitalstrackerwithreminders.data.VitalsEntity
import com.pregnancyvitalstrackerwithreminders.data.VitalsRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: VitalsRepository
    val vitalsList: LiveData<List<VitalsEntity>>

    init {
        val dao = AppDatabase.getDatabase(application).vitalsDao()
        repo = VitalsRepository(dao)
        vitalsList = repo.allVitals
    }

    fun addVitals(vitals: VitalsEntity) {
        viewModelScope.launch {
            repo.insert(vitals)
        }
    }
}
