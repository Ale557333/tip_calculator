package com.example.tip_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tip_calculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0
        binding.optionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 12
            }
        }

        binding.optionTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 15
            }
        }

        binding.optionThree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 18
            }
        }

        binding.optionFour.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 20
            }
        }

        binding.btnDone.setOnClickListener {
            val totalTableTemporary = binding.tieTotal.text
            val numberOfPeopleTemporary = binding.tiePeople.text

            if (totalTableTemporary?.isEmpty() == true ||
                numberOfPeopleTemporary?.isEmpty() == true
            ) {
                Snackbar
                    .make(binding.tieTotal, "Please fill in all the fields", Snackbar.LENGTH_LONG)
                    .show()

            } else {
                val tableAmount: Float = totalTableTemporary.toString().toFloat()
                val numberOfPeople: Int = numberOfPeopleTemporary.toString().toInt()

                val totalTable = tableAmount / numberOfPeople
                val tipCalculate = totalTable * percentage / 100
                val totalWithTip = totalTable + tipCalculate
                binding.tvResult.text = "Total including tip: $totalWithTip"
            }
        }

        binding.btnClean.setOnClickListener {
            binding.tvResult.text = ""
            binding.tieTotal.setText("")
            binding.tiePeople.setText("")
            binding.optionOne.isChecked = false
            binding.optionTwo.isChecked = false
            binding.optionThree.isChecked = false
            binding.optionFour.isChecked = false
        }
    }
}