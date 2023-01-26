package com.example.googlecodelabs

import android.icu.text.NumberFormat
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.googlecodelabs.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val costOfService = binding.costOfService.text.toString().toDouble()
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 20
            R.id.option_eighteen_percent -> 18
            else -> 15
        }
        var finalSum = costOfService * tipPercentage / 100
        if (binding.roundUpTip.isChecked) {
            finalSum = ceil(finalSum)
        }
        binding.tipAmount.text = getString(
            R.string.tip_amount_result,
            NumberFormat.getCurrencyInstance().format(finalSum)
        )
    }
}