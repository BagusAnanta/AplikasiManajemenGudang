package com.bsoftware.aplikasimanajemengudang.databaseAPIInterface

import com.bsoftware.aplikasimanajemengudang.dataClass.DataBarangDataClass
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface DataBarangDatabaseAPI {

    @GET("Read.php")
    suspend fun readDataBarang() : List<DataBarangDataClass>

    @FormUrlEncoded
    @POST("Create.php")
    suspend fun createDataBarang(
        @Field("ID_Barang") idbarang : String?,
        @Field("NamaBarang") namabarang : String?,
        @Field("Kategori") kategori : String?,
        @Field("Jumlah") jumlah : Int?,
        @Field("Lokasi") lokasi : String?,
        @Field("TanggalMasuk") tanggalmasuk : String?,
        @Field("HargaBarang") hargabarang : String?,
        @Field("Status") status : String?,
        @Field("Catatan") catatan : String?
    ) : Response<DataBarangDataClass>

    @FormUrlEncoded
    @POST("Update.php")
    suspend fun updateDataBarang(
        @Field("ID_Barang") idbarang : String?,
        @Field("NamaBarang") namabarang : String?,
        @Field("Kategori") kategori : String?,
        @Field("Jumlah") jumlah : Int?,
        @Field("Lokasi") lokasi : String?,
        @Field("TanggalMasuk") tanggalmasuk : String?,
        @Field("HargaBarang") hargabarang : String?,
        @Field("Status") status : String?,
        @Field("Catatan") catatan : String?
    ) : Response<DataBarangDataClass>

    @FormUrlEncoded
    @POST("Delete.php")
    suspend fun deleteDataBarangById(
        @Field("ID_Barang") idbarang: String?
    ) : Response<DataBarangDataClass>
}