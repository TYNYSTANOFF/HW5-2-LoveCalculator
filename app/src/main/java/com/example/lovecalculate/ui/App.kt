package com.example.lovecalculate.ui

import android.app.Application
import androidx.room.Room
import com.example.lovecalculate.room.AppDataBase
import com.example.lovecalculate.network.helpers.LoveApi
import com.example.lovecalculate.network.helpers.RetrofitService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {

        lateinit var loveApi: LoveApi

lateinit var dataBase : AppDataBase

fun getInstance(): AppDataBase {
    return dp
}
        lateinit var dp : AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        dp = Room.databaseBuilder(this, AppDataBase::class.java, "love-base").allowMainThreadQueries().build()
        val retrofitService = RetrofitService()
        loveApi = retrofitService.getApi()
    }
    fun getDataBase(): AppDataBase {
        return dataBase
    }

}