package com.example.cambiarpantallas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cambiarpantallas.ui.theme.CambiarPantallasTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CambiarPantallasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MiApp()
                }
            }
        }
    }
}



@Composable
fun MiApp() {
    var pantallaActual by remember { mutableStateOf(1) }

    when (pantallaActual) {
        1 -> Pantalla1(
            onCambiarPantalla = {
                pantallaActual = 2
            }
        )

        2 -> Pantalla2()
    }
}

@Composable
fun Pantalla1 (onCambiarPantalla: () -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Pantalla 1")
        Button(
            onClick = onCambiarPantalla
        ){Text("Ir a Pantalla 2")}
    }

}

@Composable
fun Pantalla2 (){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){Text("Pantalla 2")}
}

@Preview(showBackground = true)
@Composable
fun MiAppPreview() {
    CambiarPantallasTheme {
        MiApp()
    }
}