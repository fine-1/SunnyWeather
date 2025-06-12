package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName
//按照json数据格式定义
class PlaceResponse(val status: String, val places: List<Place>)

class Place(val name: String, val location: Location, @SerializedName("formatted_address") val address: String)//让JSON字段和Kotlin字段之间建立 映射关系

class Location(val lng: String, val lat: String)
