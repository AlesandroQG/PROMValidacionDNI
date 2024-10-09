package com.alesandro.validaciondni

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnValidar(view:View) {
        val resultLabel = findViewById<TextView>(R.id.resultLabel)
        val numbersText = findViewById<EditText>(R.id.numbersText)
        val letterText = findViewById<EditText>(R.id.letterText)
        if (numbersText.text.isNullOrEmpty() or letterText.text.isNullOrEmpty()) {
            resultLabel.text = "Error"
        } else {
            val numbers: Int = numbersText.text.toString().toInt()
            val letter = letterText.text.toString()
            if (calcularDNI(numbers,letter)) {
                resultLabel.text = "DNI correcto"
            } else {
                resultLabel.text = "DNI incorrecto"
                letterText.text.clear()
            }
        }
    }

    fun calcularDNI(numeros:Int, letra:String): Boolean {
        var arr = arrayOf('T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E')
        val rtdo = numeros % 23
        val l = arr[rtdo].toString()
        return letra.equals(l)
    }

}