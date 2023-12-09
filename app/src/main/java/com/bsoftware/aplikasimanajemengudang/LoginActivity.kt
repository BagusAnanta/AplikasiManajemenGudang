package com.bsoftware.aplikasimanajemengudang

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.bsoftware.aplikasimanajemengudang.dataViewModel.LoginViewModel
import com.bsoftware.aplikasimanajemengudang.sharePref.SharePreferenceLogin
import com.bsoftware.aplikasimanajemengudang.ui.theme.AplikasiManajemenGudangTheme

class LoginActivity : ComponentActivity() {

    private val loginviewmodel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiManajemenGudangTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context : Context = LocalContext.current
                    val activity : Activity? = (LocalContext.current as? Activity)

                    if(SharePreferenceLogin(activity!!).getLoginState()){
                        // if login data already exist
                        context.startActivity(Intent(context,MainActivity::class.java))
                        activity.finish()
                    } else {
                        LoginPage(loginViewModel = loginviewmodel,this)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(loginViewModel: LoginViewModel, lifecycleOwner: LifecycleOwner){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var usernameData : String?
    var passwordData : String?

    val focusmanager = LocalFocusManager.current
    val context : Context = LocalContext.current
    val activity : Activity? = (LocalContext.current as? Activity)

    Column(
        modifier = Modifier
            .padding(start = 20.dp,end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username,
            onValueChange = {username = it},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Username",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = password,
            onValueChange = {password = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            label = {
                Text(
                    text = "Password",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusmanager.clearFocus() }
            )
        )

        OutlinedButton(
            onClick = {
                loginViewModel.livedataLoginData.observe(lifecycleOwner, Observer { logindata ->
                    for(login in logindata){
                        usernameData = login.username
                        passwordData = login.password

                        if(username == usernameData && password == passwordData){
                            // if a username and password equals like database we intent to admin
                            SharePreferenceLogin(activity!!).setLoginState(true)
                            SharePreferenceLogin(activity).setUsername(username)
                            context.startActivity(Intent(context,MainActivity::class.java))
                            activity.finish()

                        } else {
                            // toast username and password wrong
                            Toast.makeText(context,"You Username and Password Incorrect, please try again", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
                loginViewModel.readDataLogin()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = "Sign In",
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginActivityPreview() {
    AplikasiManajemenGudangTheme {
        // Greeting6("Android")
    }
}