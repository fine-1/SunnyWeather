package com.sunnyweather.android.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Location

class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()
    //放到ViewModel 中可以保证它们在手机屏幕发生旋 转的时候不会丢失
    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = locationLiveData.switchMap{ location ->
        Repository.refreshWeather(location.lng, location.lat) //仓库层返回的LiveData 对象就可以转换成一个可供Activity观察的LiveData 对象
    }
    fun refreshWeather(lng: String, lat: String) { //刷新天气信息
        locationLiveData.value = Location(lng, lat) //封装经纬度并赋值给locationLiveData
    }
}
