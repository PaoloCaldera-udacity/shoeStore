package com.udacity.shoestore.viewmodels

import androidx.databinding.InverseMethod
import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe


class SharedViewModel : ViewModel() {

    // LiveData variable: list of Shoe objects
    private val _shoeList: MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    // LiveData variable: new Shoe entry (2-way data binding)
    val shoeEntry: MutableLiveData<Shoe> = MutableLiveData()

    // Login status. true = logged in; false = logged out
    private var loginStatus: Boolean = false


    init {
        cleanShoeEntry()
    }


    /**
     * Change the login status
     */
    fun editLoginStatus() {
        loginStatus = !loginStatus
    }

    /**
     * Function called in case the SAVE button is pressed. Adds a Shoe item to the shoes list
     * and cleans the new entry
     */
    fun addToList() {
        _shoeList.value?.add(shoeEntry.value!!)
        cleanShoeEntry()
    }

    /**
     * Function called in case the CANCEL button is pressed. Cleans the new entry
     */
    fun backToList() {
        cleanShoeEntry()
    }


    /**
     * Cleans the shoeEntry variable when navigation goes back to the list
     */
    private fun cleanShoeEntry() {
        shoeEntry.value = Shoe("", 0.0, "", "")
    }
}


/**
 * ViewModel FACTORY class
 */
@Suppress("UNCHECKED_CAST")
class SharedViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return SharedViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


/**
 * CONVERTER object from double to string and viceversa, applied to the size variable in Shoe
 */
object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(
        value: Double
    ): String {
        if (value.isNaN()) return ""
        return value.toString()
    }

    @JvmStatic fun stringToDouble(
        value: String
    ): Double {
        if (value.isEmpty()) return 0.0
        return value.toDouble()
    }
}