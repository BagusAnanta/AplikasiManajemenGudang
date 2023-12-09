package com.bsoftware.aplikasimanajemengudang.dataViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoftware.aplikasimanajemengudang.dataClass.DataBarangDataClass
import com.bsoftware.aplikasimanajemengudang.databaseAPIInterface.DataBarangDatabaseAPI
import com.bsoftware.aplikasimanajemengudang.retrofitInit.RetrofitInitial
import kotlinx.coroutines.launch

class DataBarangViewModel : ViewModel() {
    private val apiInterfaceDataBarang = RetrofitInitial().retrofitDataBarang.create(DataBarangDatabaseAPI::class.java)
    private val mutableListDataBarang = MutableLiveData<List<DataBarangDataClass>>()
    val livedataDataBarang : LiveData<List<DataBarangDataClass>> = mutableListDataBarang

    private var connectionStatus : Boolean = false;

    // read data barang in here
    fun readDataBarang(){
        viewModelScope.launch {
            try {
                val getDataBarang = apiInterfaceDataBarang.readDataBarang()
                mutableListDataBarang.postValue(getDataBarang)
            } catch (e : Exception){
                Log.e("readDataBarang() Exception", e.toString())
                // setconnectionstatus in here
                setConnection(false)
            }
        }
    }

    // create data barang in here
    fun createDataBarang(
        idbarang : String?,
        namabarang : String?,
        kategori : String?,
        jumlah : Int?,
        lokasi : String?,
        tanggalmasuk : String?,
        hargabarang : String?,
        status : String?,
        catatan : String?
    ){
        viewModelScope.launch {
            try {
                val createDataBarang = apiInterfaceDataBarang.createDataBarang(
                   idbarang, namabarang, kategori, jumlah, lokasi, tanggalmasuk, hargabarang, status, catatan
                )

                Log.d("CreateDataBarang", createDataBarang.toString())

                if(!createDataBarang.isSuccessful){
                    Log.e("CreateDataBarang Fail",createDataBarang.message())
                } else {
                    Log.i("CreateDataBarang Success", createDataBarang.message())
                }
            } catch (e : Exception){
                Log.e("createDataBarang() Exception", e.toString())
            }
        }
    }

    // update data barang in here
    fun updateDataBarang(
        idbarang : String?,
        namabarang : String?,
        kategori : String?,
        jumlah : Int?,
        lokasi : String?,
        tanggalmasuk : String?,
        hargabarang : String?,
        status : String?,
        catatan : String?
    ){
        viewModelScope.launch {
            try{
                val updateDataBarang = apiInterfaceDataBarang.updateDataBarang(
                    idbarang, namabarang, kategori, jumlah, lokasi, tanggalmasuk, hargabarang, status, catatan
                )

            } catch (e : Exception){
                Log.e("updateDataBarang() Exception", e.toString())
            }
        }
    }

    //delete data barang in here
    fun deleteDataBarangById(idBarang : String?){
        viewModelScope.launch {
            try {
                val deleteDataBarang = apiInterfaceDataBarang.deleteDataBarangById(idBarang)
                if(deleteDataBarang.isSuccessful){
                    // if delete successfull
                    readDataBarang()
                } else {
                    Log.e("DeleteDataBarangById() Error", "Error While Delete a data")
                }
            } catch (e : Exception){
                Log.e("deleteDataBarangById() Exception", e.toString())
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