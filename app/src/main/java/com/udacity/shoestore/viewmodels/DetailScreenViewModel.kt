package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailScreenViewModel : ViewModel() {
    private var _shoeName = MutableLiveData<String>()
    val shoeName: LiveData<String>
        get() = _shoeName

    private var _shoeCompany = MutableLiveData<String>()
    val shoeCompany: LiveData<String>
        get() = _shoeCompany

    private var _shoeSize = MutableLiveData<String>()
    val shoeSize: LiveData<String>
        get() = _shoeSize

    private var _shoeDescription = MutableLiveData<String>()
    val shoeDescription: LiveData<String>
        get() = _shoeDescription

    init {
        _shoeName.value = ""
        _shoeCompany.value = ""
        _shoeSize.value = ""
        _shoeDescription.value = ""

    }
}