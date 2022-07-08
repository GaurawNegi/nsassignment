package com.gauraw.nsassessment.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gauraw.nsassessment.presentation.data.model.Station
import com.gauraw.nsassessment.presentation.data.usecase.HomeScreenUseCase
import com.gauraw.nsassessment.presentation.utils.StationListUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val homeScreenUseCase: HomeScreenUseCase
) : ViewModel() {

    private val stationList: MutableLiveData<List<Station>> = MutableLiveData()

    fun getStationList(): LiveData<List<Station>> {
        return stationList
    }

    fun loadStations() {
        viewModelScope.launch {
            stationList.value = StationListUtils().sortByLocations(
                homeScreenUseCase.provideStationList(),
                USER_LATITUDE,
                USER_LONGITUDE
            )
        }
    }

    companion object {
        const val USER_LATITUDE = 52.087966
        const val USER_LONGITUDE = 5.113372
    }

}