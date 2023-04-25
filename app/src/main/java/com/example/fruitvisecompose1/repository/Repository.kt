package com.example.fruityvisecompose.repository

import com.example.fruityvisecompose.data.FruitsItemModel

interface Repository {
    suspend fun getFruits(): ArrayList<FruitsItemModel>
}