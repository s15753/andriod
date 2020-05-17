package com.example.bmi_kotlin

import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_show_calories.*

class ShowCaloriesActivity : AppCompatActivity() {

    var radio: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_calories)

        val bundle : Bundle = intent.extras!!
        val kg: Int = bundle.getInt("KG")
        val cm:Int = bundle.getInt("CM")
        
        kcalRadioGroup.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val rb: RadioButton = findViewById(checkedId)
            radio = rb.text.toString()
        })

        buttonCalculateKcal.setOnClickListener {
            kcalError.text = ""
            kcalResult.text = ""
            if (radio.equals("Female") && editTextAge.text.toString().length > 0
                    && !editTextAge.text.toString().equals("0")) {
//                Log.v("AGE", age.toString())
                val fresult = femaleKcalLimit(kg, cm, editTextAge.text.toString().toInt())
                kcalResult.text = getString(R.string.kcal_result) + fresult
            }
            else if (radio.equals("Male") && editTextAge.text.toString().length > 0
                    && !editTextAge.text.toString().equals("0")) {
                val mresult = maleKcalLimit(kg, cm, editTextAge.text.toString().toInt())
                kcalResult.text = getString(R.string.kcal_result) + mresult
            }
            else kcalError.text = getString(R.string.text_error)
        }
    }

    fun femaleKcalLimit(kg: Int, cm: Int, age: Int): Int {
        return (655.1 + (9.567 * kg) + (1.85 * cm) - (4.68 * age)).toInt()
    }

    fun maleKcalLimit(kg: Int, cm: Int, age: Int): Int {
        return (66.47 + (13.7 * kg) + (5.0 * cm) - (6.76 * age)).toInt()
    }
}
