package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    private val _shoeList : MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    fun addToList(
        name: String,
        size: Double,
        company: String,
        description: String
    ) {
        _shoeList.value?.add(Shoe(name, size, company, description))
    }

}


class SharedViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return SharedViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}