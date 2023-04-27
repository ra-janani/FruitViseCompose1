package com.example.fruityvisecompose1.repository

import com.example.fruityvisecompose1.data.FruitsItemModel

interface Repository {
    suspend fun getFruits(): ArrayList<FruitsItemModel>
}