package com.bsoftware.aplikasimanajemengudang

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoftware.aplikasimanajemengudang.dataViewModel.DataBarangViewModel
import com.bsoftware.aplikasimanajemengudang.ui.theme.AplikasiManajemenGudangTheme

class DeleteDataBarangActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiManajemenGudangTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DeletePage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeletePage(databarangviewmodel: DataBarangViewModel = DataBarangViewModel()) {
    // delete page with id number
    var idbarang by remember { mutableStateOf("") }
    val context : Context = LocalContext.current
    val activity : Activity? = (LocalContext.current as? Activity)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column{
            Text(
                text = "Hapus Data Barang",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Hapus data barang dengan menggunakan Id Barang, silahkan lihat Id barang pada barang atau lihat di kartu lihat barang",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
        }

        Column(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            OutlinedTextField(
                value = idbarang,
                onValueChange = {idbarang = it},
                label = {
                    Text(
                        text = "Masukkan ID Barang",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
            )

            Button(
                onClick = {
                    databarangviewmodel.deleteDataBarangById(idbarang)
                    // intent back into homeAdminActivity
                    Toast.makeText(context,"Data Berhasil Dihapus", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context,MainActivity::class.java))
                    activity?.finish()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(text = "Hapus Data")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    AplikasiManajemenGudangTheme {
        DeletePage()
    }
}