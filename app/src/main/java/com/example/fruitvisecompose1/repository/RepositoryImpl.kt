package com.example.fruityvisecompose1.repository

import com.example.fruityvisecompose1.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
):Repository {

    override suspend fun getFruits() = apiRequest.getFruits()
}