package com.example.bmi_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    var kg: Int? = null
    var cm: Int? = null
    var calculatedCount: Double = 0.0
    var calculatedGroup: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        buttonCalculate.setOnClickListener {
            textError.text = ""

            if (editTextWeight.text.toString().length > 0
                    && editTextHeight.text.toString().length > 0
                    && !editTextWeight.text.toString().equals("0")
                    && !editTextHeight.text.toString().equals("0")) {
                kg = editTextWeight.text.toString().toInt()
                cm = editTextHeight.text.toString().toInt()

                calculatedCount = calculateCount(kg!!, cm!!)
                calculatedGroup = calculateGroup(calculatedCount!!)

                textViewBmiCount.text = calculatedCount.toString()
                textViewBmiGroup.text = calculatedGroup.toString()
            } else textError.text = getString(R.string.text_error)
        }

        buttonKcal.setOnClickListener {
            textError.text = ""

            if (editTextWeight.text.toString().length > 0
                    && editTextHeight.text.toString().length > 0
                    && !editTextWeight.text.toString().equals("0")
                    && !editTextHeight.text.toString().equals("0")) {
                val intent = Intent(this, ShowCaloriesActivity::class.java)
                intent.putExtra("KG", editTextWeight.text.toString().toInt())
                intent.putExtra("CM", editTextHeight.text.toString().toInt())
                startActivity(intent)
            } else textError.text = getString(R.string.text_error)
        }

        buttonDish.setOnClickListener {
            textError.text = ""

            if(calculatedGroup.equals("underweight")
                    || calculatedGroup.equals("optimum")
                    || calculatedGroup.equals("overweight")) {
                val intent = Intent(this, ShowDishActivity::class.java)
                intent.putExtra("GROUP", calculatedGroup)
                startActivity(intent)
            } else textError.text = getString(R.string.text_error)
        }
    }

    fun calculateCount(kg: Int, cm: Int) : Double {
        return kg / (Math.pow(cm.toDouble(), 2.0)) * 10000
    }

    fun calculateGroup(calculatedCount: Double) : String {
        if (calculatedCount <= 18.49) return "underweight"
        else if (calculatedCount > 18.49 && calculatedCount <= 24.49) return "optimum"
        else if (calculatedCount > 24.49 && calculatedCount <= 29.99) return "overweight"
        else return "obesity"
    }
}
