package com.bsoftware.aplikasimanajemengudang.dataClass

import com.google.gson.annotations.SerializedName

data class DataBarangDataClass(
     @SerializedName("ID_Barang")       var idbarang : String?,
     @SerializedName("NamaBarang")      var namabarang : String?,
     @SerializedName("Kategori")        var kategori : String?,
     @SerializedName("Jumlah")          var jumlah : Int?,
     @SerializedName("Lokasi")          var lokasi : String?,
     @SerializedName("TanggalMasuk")    var tanggalmasuk : String?,
     @SerializedName("HargaBarang")     var hargabarang : String?,
     @SerializedName("Status")          var status : String?,
     @SerializedName("Catatan")         var catatan : String?
 ) : java.io.Serializable