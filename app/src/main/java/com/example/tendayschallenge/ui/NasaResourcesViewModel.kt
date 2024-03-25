package com.example.tendayschallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tendayschallenge.data.ApiInstance
import com.example.tendayschallenge.data.NasaApiService
import com.example.tendayschallenge.data.model.NasaResource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NasaResourcesViewModel : ViewModel() {
    private val _nasaResourceList = MutableStateFlow<List<NasaResource>>(emptyList())
    val nasaResourceList: StateFlow<List<NasaResource>> = _nasaResourceList.asStateFlow()

    private val nasaApi = ApiInstance().createService(NasaApiService::class.java)

    fun getNasaResourceList() {
        viewModelScope.launch {
            _nasaResourceList.value = nasaApi.getImageList("2024-03-20", "2024-03-25")
        }
    }
}