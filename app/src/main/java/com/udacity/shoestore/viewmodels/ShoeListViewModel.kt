package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList


    init {
        _shoeList.value = mutableListOf()
    }

    fun addShoe(
        name: String = "",
        size: Double = 0.0,
        company: String = "",
        description: String = ""
    ) {
        _shoeList.value?.add(Shoe(name, size, company, description))
    }


}