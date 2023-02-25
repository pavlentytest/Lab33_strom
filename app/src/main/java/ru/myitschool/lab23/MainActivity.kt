package ru.myitschool.lab23

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding
import kotlin.math.ln

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.content.button.setOnClickListener {
            getValues()
        }
    }

    private fun getValues() {
        val sizeText = binding.content.sizeParam.text.toString()
        val shapeText = binding.content.shapeParam.text.toString()
        val rateText = binding.content.rateParam.text.toString()

        val n = if(sizeText == "") 0 else sizeText.toInt()
        val k = shapeText.toInt()
        val r = rateText.toDouble()

        val calcResult = DoubleArray(n)
        repeat(n) {
            calcResult[it] = calc(k, r)
            Log.d("RRR", calcResult[it].toString())
        }

        val intent = Intent(applicationContext, ResultActivity::class.java)
        intent.putExtra("arr", calcResult)
        startActivity(intent)
    }

    private fun calc(kk: Int, rr: Double) : Double {
        var total = 0.0
        repeat(kk) {
            val rand = Math.random()
            total += ln(rand)
        }
        return -total/rr
    }
}