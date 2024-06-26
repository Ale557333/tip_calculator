package com.example.tip_calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tip_calculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDone.setOnClickListener {
            val totalTableTemporary = binding.tieTotal.text
            val numberOfPeopleTemporary = binding.tiePeople.text
            val tipInsert = binding.tieTipInsert.text

            if (totalTableTemporary?.isEmpty() == true ||
                numberOfPeopleTemporary?.isEmpty() == true ||
                tipInsert?.isEmpty() == true
            ) {
                Snackbar
                    .make(binding.tieTotal,
                        getString(R.string.please_fill_in_all_the_fields), Snackbar.LENGTH_LONG)
                    .show()

            } else {
                val tableAmount: Float = totalTableTemporary.toString().toFloat()
                val numberOfPeople: Int = numberOfPeopleTemporary.toString().toInt()
                val percentage: Int = tipInsert.toString().toInt()

                val totalTable = tableAmount / numberOfPeople
                val tipCalculate = totalTable * percentage / 100
                val totalWithTip = totalTable + tipCalculate

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("tableAmount", tableAmount)
                    putExtra("numberOfThePeople", numberOfPeople)
                    putExtra("percentage", percentage)
                    putExtra("totalWithTip", totalWithTip)
                }
                clean()
                startActivity(intent)
            }
        }

        binding.btnClean.setOnClickListener {
            clean()
        }
    }

    private fun clean() {
        binding.tieTotal.setText("")
        binding.tiePeople.setText("")
        binding.tieTipInsert.setText("")
    }
}