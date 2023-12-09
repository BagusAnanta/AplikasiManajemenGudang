package com.bsoftware.aplikasimanajemengudang.retrofitInit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitial {
    var retrofitLogin = Retrofit.Builder()
        .baseUrl("http://192.168.100.11/SistemManagementGudang/UserLoginTable/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var retrofitDataBarang = Retrofit.Builder()
        .baseUrl("http://192.168.100.11/SistemManagementGudang/DataBarangTable/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}