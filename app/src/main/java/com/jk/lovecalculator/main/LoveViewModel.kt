package com.jk.lovecalculator.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jk.lovecalculator.remote.model.LoveModel
import com.jk.lovecalculator.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    fun getLiveLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLiveLove(firstName, secondName)
    }
}