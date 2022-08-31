package com.arth.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Toast
import com.arth.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonResult.setOnClickListener { calculate() }
        binding.button0.setOnClickListener { input(0) }
        binding.button1.setOnClickListener { input(1) }
        binding.button2.setOnClickListener { input(2) }
        binding.button3.setOnClickListener { input(3) }
        binding.button4.setOnClickListener { input(4) }
        binding.button5.setOnClickListener { input(5) }
        binding.button6.setOnClickListener { input(6) }
        binding.button7.setOnClickListener { input(7) }
        binding.button8.setOnClickListener { input(8) }
        binding.button9.setOnClickListener { input(9) }
        binding.buttonClear.setOnClickListener { clear() }
        binding.buttonDot.setOnClickListener { inputSymbol('.') }
        binding.buttonMinus.setOnClickListener { inputSymbol('-') }
        binding.buttonPlus.setOnClickListener { inputSymbol('+') }
        binding.buttonMulti.setOnClickListener { inputSymbol('*') }
        binding.buttonDivision.setOnClickListener { inputSymbol('/') }
    }

    private fun calculate() {
        if (binding.resultText.text == "") {
            val toast = Toast.makeText(this, "Input a Value", Toast.LENGTH_SHORT)
            toast.show()

        } else {
            var expression = ExpressionBuilder(binding.resultText.text.toString()).build()
            var result = expression.evaluate()
            binding.resultText.text = (result.toString())
        }
    }

    private fun input(x: Int?) {
        binding.resultText.append(x.toString())
    }

    private fun inputSymbol(x: Char?) {
        binding.resultText.append(x.toString())
    }

    private fun clear() {
        binding.resultText.text = ("")
    }
}