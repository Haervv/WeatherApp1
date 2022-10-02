package com.VitaliyProj.weatherapp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.VitaliyProj.weatherapp.adapters.WeatherModel

class MainViewModel:ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}