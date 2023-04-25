package com.example.fruityvisecompose.repository

import com.example.fruityvisecompose.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
):Repository {

    override suspend fun getFruits() = apiRequest.getFruits()
}