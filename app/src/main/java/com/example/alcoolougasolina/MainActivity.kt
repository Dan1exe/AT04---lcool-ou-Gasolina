package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual: Double = 0.7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("PDM24.1", "No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        val textMsg: TextView = findViewById(R.id.textMsg)
        val edGasolina: EditText = findViewById(R.id.edGasolina)
        val edAlcool: EditText = findViewById(R.id.edAlcool)

        btCalc.setOnClickListener(View.OnClickListener {
            val gasolina: Double = edGasolina.text.toString().toDoubleOrNull() ?: 0.0
            val alcool: Double = edAlcool.text.toString().toDoubleOrNull() ?: 0.0

            val resultado: Double
            val mensagem: String

            when (percentual) {
                0.7 -> {
                    resultado = gasolina * 0.7
                    mensagem = if (resultado > alcool) {
                        "Abasteça com Álcool"
                    } else {
                        "Abasteça com Gasolina"
                    }
                }
                0.75 -> {
                    resultado = gasolina * 0.75
                    mensagem = if (resultado > alcool) {
                        "Abasteça com Álcool"
                    } else {
                        "Abasteça com Gasolina"
                    }
                }
                else -> {
                    resultado = 0.0
                    mensagem = "Percentual não suportado"
                }
            }

            textMsg.text = mensagem
            Log.d("PDM24", "No btCalcular, $percentual")
        })
    }

    override fun onResume() {
        super.onResume()
        Log.d("PDM24", "No onResume, $percentual")
    }

    override fun onStart() {
        super.onStart()
        Log.v("PDM24", "No onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.e("PDM24", "No onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("PDM24", "No onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.wtf("PDM24", "No Destroy")
    }
}
