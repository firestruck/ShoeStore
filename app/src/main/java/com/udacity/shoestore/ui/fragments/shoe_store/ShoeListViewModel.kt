package com.udacity.shoestore.ui.fragments.shoe_store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.*
import kotlin.collections.ArrayList

class ShoeListViewModel: ViewModel() {

    private  var _shoeList = MutableLiveData<Shoe>()
    var shoeList: LiveData<Shoe>
    get() = _shoeList








init {

    populateList()

}




    private fun populateList() {


          _shoeList.value?.name = "1"
        _shoeList.value?.name = "2"
        _shoeList.value?.name = "3"
        _shoeList.value?.name = "4"
            _shoeList.value?.size = 43.0




    }



    override fun onCleared() {
        super.onCleared()
    }

}