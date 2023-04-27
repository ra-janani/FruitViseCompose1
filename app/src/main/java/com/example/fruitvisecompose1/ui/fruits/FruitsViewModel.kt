package com.example.fruitvisecompose1.ui.fruits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruityvisecompose1.data.FruitsItemModel
import com.example.fruityvisecompose1.repository.Repository
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
        getFruitsData()
    }

    fun getFruitsData(){
        viewModelScope.launch {
            val fruits=repository.getFruits()
            _fruits.value=fruits
        }
    }

}