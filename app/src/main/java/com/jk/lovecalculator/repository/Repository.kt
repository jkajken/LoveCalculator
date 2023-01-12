package com.jk.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jk.lovecalculator.remote.LoveApi
import com.jk.lovecalculator.remote.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {

    fun getLiveLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        api.getLoveResult(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful)
                        liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.d("ololo", "onFailure:" + t.message)
                }

            })
        return liveData
    }
}