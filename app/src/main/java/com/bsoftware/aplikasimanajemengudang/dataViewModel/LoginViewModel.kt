package com.bsoftware.aplikasimanajemengudang.dataViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoftware.aplikasimanajemengudang.dataClass.LoginDataClass
import com.bsoftware.aplikasimanajemengudang.databaseAPIInterface.LoginDatabaseAPI
import com.bsoftware.aplikasimanajemengudang.retrofitInit.RetrofitInitial
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val apiInterfaceLogin = RetrofitInitial().retrofitLogin.create(LoginDatabaseAPI::class.java)
    private val mutableListLoginData = MutableLiveData<List<LoginDataClass>>()
    val livedataLoginData : LiveData<List<LoginDataClass>> = mutableListLoginData

    private var connectionStatus : Boolean = false

    fun readDataLogin(){
        viewModelScope.launch {
            try{
                val getDataLogin = apiInterfaceLogin.readLoginData()
                mutableListLoginData.postValue(getDataLogin)
            } catch (e : Exception){
                Log.e("readDataLogin() Exception", e.toString())
                // in here we gonna set connection status into false
                setConnection(false)
            }
        }
    }

    private fun setConnection(isConnection : Boolean){
        connectionStatus = isConnection
    }

    fun getConnectionStatus() : Boolean{
        return connectionStatus
    }
}