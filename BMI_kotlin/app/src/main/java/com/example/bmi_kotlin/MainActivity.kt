package com.example.bmi_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener( { launchActivityCalculator() })
    }

    private fun launchActivityCalculator() {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }
}
