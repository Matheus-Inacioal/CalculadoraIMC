package com.example.calculadoraimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)
        btnCalcular = findViewById(R.id.btnCalcular)
        textResultado = findViewById(R.id.textResultado)

        btnCalcular.setOnClickListener {
            calcularIMC()
        }
    }

    private fun calcularIMC() {
        val pesoStr = editPeso.text.toString()
        val alturaStr = editAltura.text.toString()

        if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {
            val peso = pesoStr.toFloat()
            val altura = alturaStr.toFloat()

            val imc = peso / (altura * altura)

            val resultado = when {
                imc < 18.5 -> "Abaixo do Peso"
                imc < 24.9 -> "Peso Normal"
                imc < 29.9 -> "Sobrepeso"
                imc < 34.9 -> "Obesidade Grau 1"
                imc < 39.9 -> "Obesidade Grau 2"
                else -> "Obesidade Grau 3"
            }

            val mensagem = "Seu IMC é %.2f, o que indica: $resultado".format(imc)
            textResultado.text = mensagem
        } else {
            textResultado.text = "Preencha o peso e a altura."
        }
    }
}
