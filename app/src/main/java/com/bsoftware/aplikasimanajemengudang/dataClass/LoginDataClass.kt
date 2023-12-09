package com.bsoftware.aplikasimanajemengudang.dataClass

import com.google.gson.annotations.SerializedName

data class LoginDataClass(
    @SerializedName("Username") var username : String?,
    @SerializedName("Password") var password : String?
) : java.io.Serializable