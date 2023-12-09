package com.bsoftware.aplikasimanajemengudang.sharePref

import android.app.Activity
import android.content.Context

class SharePreferenceLogin(activity : Activity) {

    private val sharePrefLogin = activity.getSharedPreferences("LoginSharePref", Context.MODE_PRIVATE)
    private val sharePrefEdit = sharePrefLogin.edit()

    fun setLoginState(isLogin : Boolean){
        sharePrefEdit.apply {
            putBoolean(LOGINSTATEKEY,isLogin)
            commit()
        }
    }

    fun getLoginState() : Boolean {
        return sharePrefLogin.getBoolean(LOGINSTATEKEY,false)
    }

    fun setUsername(username : String){
        sharePrefEdit.apply {
            putString(USERNAMEKEY,username)
            commit()
        }
    }

    fun getUsername() : String{
        return sharePrefLogin.getString(USERNAMEKEY,"")!!
    }

    companion object{
        private val LOGINSTATEKEY : String = "LoginStateKey"
        private val USERNAMEKEY : String = "usernameKey"
    }
}