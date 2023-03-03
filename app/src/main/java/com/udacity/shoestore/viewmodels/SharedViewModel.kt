package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    private val _shoeList: MutableLiveData<List<Shoe>> = MutableLiveData(mutableListOf())
    val shoeList: LiveData<List<Shoe>> get() = _shoeList

}