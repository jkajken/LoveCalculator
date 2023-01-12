package com.jk.lovecalculator.onboard

import android.content.Context
import android.content.SharedPreferences

class Prefs {
     lateinit var pref: SharedPreferences

    fun onPref(context: Context){
        pref= context.getSharedPreferences("pref_name", Context.MODE_PRIVATE)
    }

    fun isOnBoardingShow(): Boolean {
        return pref.getBoolean(BOARDING_SHOW, true)
    }

    fun saveShowBoarding(isShow: Boolean) {
        pref.edit().putBoolean(BOARDING_SHOW, isShow).apply()
    }


    companion object{
        private const val BOARDING_SHOW = "on_boarding_show"
    }
}