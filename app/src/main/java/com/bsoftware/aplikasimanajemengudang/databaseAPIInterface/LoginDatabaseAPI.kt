package com.bsoftware.aplikasimanajemengudang.databaseAPIInterface

import com.bsoftware.aplikasimanajemengudang.dataClass.LoginDataClass
import retrofit2.http.GET

interface LoginDatabaseAPI {

    @GET("Read.php")
    suspend fun readLoginData() : List<LoginDataClass>
}