package com.example.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun calculateResult(): Double {
        val billAmtText = findViewById<EditText>(R.id.billAmount)
        val tipPercText = findViewById<EditText>(R.id.tipPercent)

        val billAmt = billAmtText.text.toString().toDouble()
        val tipPerc = tipPercText.text.toString().toDouble()

        val tip: Double = billAmt * (tipPerc * 0.01)
        return tip
    }

    private fun calculateTotal(tip: Double): Double {
        val billAmtText = findViewById<EditText>(R.id.billAmount)

        val billAmt = billAmtText.text.toString().toDouble()

        val total: Double = billAmt + tip

        return total
    }

    fun showResult(view: View){
        val tipResult = calculateResult()
        val totalResult = calculateTotal(tipResult)

        val tipText = findViewById<TextView>(R.id.resultText)
        val resultTextFormat = ("%.2f".format(tipResult))

        tipText.text = resultTextFormat

        val totalText = findViewById<TextView>(R.id.resultText2)
        val resultText2Format = ("%.2f".format(totalResult))

        totalText.text = resultText2Format

    }
}