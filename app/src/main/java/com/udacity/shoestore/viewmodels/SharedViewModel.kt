package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe


class SharedViewModel : ViewModel() {

    // LiveData variable, containing the list of Shoe objects
    private val _shoeList: MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    // LiveData variable, containing the entries of the new Shoe object
    private val _newShoeEntry: MutableLiveData<Shoe> = MutableLiveData()
    val newShoeEntry: LiveData<Shoe> get() = _newShoeEntry

    // Login status. true = logged in; false = logged out
    private var loginStatus: Boolean = false


    /**
     * Adds a Shoe item to the shoes list
     */
    fun addToList() {
        _shoeList.value?.add(newShoeEntry.value!!)
    }


    /**
     * Change the login status
     */
    fun editLoginStatus() {
        loginStatus = !loginStatus
    }

}


/**
 * Instantiate the viewModel object through the Factory class
 */
class SharedViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return SharedViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}