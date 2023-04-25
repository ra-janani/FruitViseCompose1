package com.example.fruityvisecompose.ui.fruits

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruityvisecompose.data.FruitsItemModel
import com.example.fruityvisecompose.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FruitsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _fruits = MutableStateFlow<List<FruitsItemModel>>(emptyList())

    val fruits:StateFlow<List<FruitsItemModel>> = _fruits

    init{
        viewModelScope.launch {
            val fruits=repository.getFruits()
            _fruits.value=fruits
        }
    }


}