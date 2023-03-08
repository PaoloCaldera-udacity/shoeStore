package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe


class SharedViewModel : ViewModel() {

    // LiveData variable: list of Shoe objects
    private val _shoeList: MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    // LiveData variable: new Shoe entry (2-way data binding)
    val shoeNameEntry: MutableLiveData<String> = MutableLiveData()
    val shoeCompanyEntry: MutableLiveData<String> = MutableLiveData()
    val shoeSizeEntry: MutableLiveData<String> = MutableLiveData()
    val shoeDescriptionEntry: MutableLiveData<String> = MutableLiveData()

    // Login status. true = logged in; false = logged out
    private var loginStatus: Boolean = false


    /**
     * Adds a Shoe item to the shoes list
     */
    fun addToList() {
        _shoeList.value?.add(Shoe(
            name = shoeNameEntry.value!!,
            size = shoeSizeEntry.value!!.toDouble(),
            company = shoeCompanyEntry.value!!,
            description = shoeDescriptionEntry.value!!
        ))

        cleanEntry()
    }


    /**
     * Change the login status
     */
    fun editLoginStatus() {
        loginStatus = !loginStatus
    }


    private fun cleanEntry() {
        shoeNameEntry.value = ""
        shoeSizeEntry.value = ""
        shoeCompanyEntry.value = ""
        shoeDescriptionEntry.value = ""
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