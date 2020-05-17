package com.example.bmi_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_show_dish.*

class ShowDishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_dish)

        val bundle : Bundle = intent.extras!!
        val group: String = bundle.getString("GROUP").toString()

        if (group == "underweight") textDish.text = getString(R.string.underweight_text)
        else if (group == "optimum") textDish.setText(getString(R.string.optimum_text))
        else if (group == "overweight") textDish.text = getString(R.string.overweight_text)
        else textDish.text = getString(R.string.default_text)
    }
}
