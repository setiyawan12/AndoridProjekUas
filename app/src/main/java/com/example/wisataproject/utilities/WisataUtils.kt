package com.example.wisataproject.utilities

import android.content.Context
import android.content.Context.MODE_PRIVATE

class WisataUtils {
    companion object{
        var API_ENDPOINT = "https://efd50c05c37b.ngrok.io/"

        fun getToken(context: Context) : String? {
            val token = context.getSharedPreferences("USER", MODE_PRIVATE)
            return token?.getString("TOKEN",null)
        }

        fun setToken(context: Context, token: String, user_id: String) {
            val pref = context.getSharedPreferences("USER", MODE_PRIVATE)
            pref.edit().apply(){
                putString("TOKEN", token)
                putString("USER_ID", user_id)
                apply()
            }
        }

        fun clearToken(context: Context){
            val pref = context.getSharedPreferences("USER", MODE_PRIVATE)
            pref.edit().clear().apply()
        }

        fun isValidPassword(password: String) = password != null;


    }
}