package com.example.lovecalculate.network.repository

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lovecalculate.fragment.HomeFragment
import com.example.lovecalculate.network.model.LoveModel
import com.example.lovecalculate.ui.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository  {
    private lateinit var navController: NavController
    fun getLoveModel(firstName:String, secondName : String):MutableLiveData<LoveModel>{
        val mutableLoveModel : MutableLiveData<LoveModel> = MutableLiveData()

        App.loveApi.getPercentage(firstName = firstName, secondName = secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if(response.isSuccessful){
                    mutableLoveModel.value = response.body()
                    Log.e("ololo", "onResponse:${mutableLoveModel.value}")
                }

            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
            Log.e("ololo", "onFailure: ${t.message}")

            }

        })

        return mutableLoveModel

    }
}