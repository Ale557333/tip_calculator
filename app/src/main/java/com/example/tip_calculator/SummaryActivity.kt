package com.example.tip_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tip_calculator.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tableAmount = intent.getFloatExtra("tableAmount", 0.0f)
        val numberOfThePeople = intent.getIntExtra("numberOfThePeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalWithTip = intent.getFloatExtra("totalWithTip", 0.0f)

        binding.tvTotalTable.text = tableAmount.toString()
        binding.tvPercentage.text = percentage.toString()
        binding.tvNumberOfPeople.text = numberOfThePeople.toString()
        binding.tvTotalWhitTip.text = totalWithTip.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
        }
        println("Alex1" + totalWithTip)

    }
}