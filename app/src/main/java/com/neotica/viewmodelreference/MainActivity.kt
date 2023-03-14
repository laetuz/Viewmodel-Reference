package com.neotica.viewmodelreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.neotica.viewmodelreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //Step 8: Initialize ViewModel
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Step 9: Define the viewModel
        //call viewModelProvider with this Activity as the owner,
        //and get from MainViewModel class.
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //Step 11(Final): Call the layout on Button click listener.
        binding.btnCalculate.setOnClickListener { layout() }
    }

    //Step 10: Create function for layout
    private fun layout() {
        binding.apply {
            //Step 10.1: Bind the Layout
            val width = edtWidth.text.toString()
            val height = edtHeight.text.toString()
            val length = edtLength.text.toString()

            //Step 10.2: Create condition where the editText can't be empty.
            when {
                width.isEmpty() -> {
                    edtHeight.error = "Is empty"
                }
                height.isEmpty() -> {
                    edtHeight.error = "Is empty"
                }
                length.isEmpty() -> {
                    edtLength.error = "Is empty"
                }
                else -> {
                    //Step 10.3: Apply viewModel and call calculate
                    viewModel.apply {
                        calculate(width, height, length)
                        //Step 10.4: Change the editText as
                        //a result variable that has been calculated from the viewModel.
                        tvResult.text = result.toString()
                    }
                }
            }
        }
    }
}