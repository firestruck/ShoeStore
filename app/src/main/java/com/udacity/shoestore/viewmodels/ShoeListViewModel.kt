package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {


    private val _navigate2List = MutableLiveData<Boolean>()
    val navigate2List: LiveData<Boolean>
        get() = _navigate2List

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList


    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe


    private val _asEmptyField = MutableLiveData<Boolean>()
    val asEmptyField: LiveData<Boolean>
        get() = _asEmptyField


    init {

        _asEmptyField.value = false
        _shoeList.value = mutableListOf()
        _shoe.value = Shoe("", 0.0, "", "")

    }


    fun addShoeBrand() {
        if (checkEmptyFields(
                shoe.value!!.name,
                shoe.value!!.size,
                shoe.value!!.company,
                shoe.value!!.description
            )
        ) {
            _shoeList.value!!.add(shoe.value!!)
            _navigate2List.value = true
            resetForm()
            _asEmptyField.value = false
        }
    }

    fun onNavigateComplete() {
        _navigate2List.value = false
    }

    fun resetForm() {
        _shoe.value = Shoe("", 0.0, "", "")
    }

    fun checkEmptyFields(name: String, size: Double, company: String, description: String): Boolean {
        if (name.isEmpty() || size.isNaN() || company.isEmpty() || description.isEmpty()) {
            _asEmptyField.value = true
            return false
        }
        return true
    }

}