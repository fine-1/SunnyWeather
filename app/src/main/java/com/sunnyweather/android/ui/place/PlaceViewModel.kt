package com.sunnyweather.android.ui.place

import androidx.lifecycle.*
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Place
import androidx.lifecycle.switchMap
class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>() //对界面上显示的城市数据进行缓存
    //观察对象
    val placeLiveData = searchLiveData.switchMap { query ->
        Repository.searchPlaces(query)//在转换函数中，发起网络请求
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

}
