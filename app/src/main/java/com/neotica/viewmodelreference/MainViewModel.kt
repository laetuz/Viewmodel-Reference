package com.neotica.viewmodelreference

import androidx.lifecycle.ViewModel

//Step 5: Extend to viewmodel
class MainViewModel: ViewModel() {
    //Step 6: Initialize variable
    var result = 0
    //Step 7: Provide function
    fun calculate(width: String, height: String, length: String){
        result = width.toInt() * height.toInt() * length.toInt()
    }
}