package com.jk.lovecalculator.remote.retrofit

import com.jk.lovecalculator.remote.LoveApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    private val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getLoveApi(): LoveApi = retrofit.create(LoveApi ::class.java)
}