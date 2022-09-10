package com.example.lovecalculate.ui

import android.app.Application
import com.example.lovecalculate.network.helpers.LoveApi
import com.example.lovecalculate.network.helpers.RetrofitService

class App : Application() {
    companion object {
        lateinit var loveApi: LoveApi

    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        loveApi = retrofitService.getApi()
    }
}