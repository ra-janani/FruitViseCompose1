package com.example.fruityvisecompose.remote

import com.example.fruityvisecompose.data.FruitsItemModel
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.BASE_URL)
    suspend fun getFruits(): ArrayList<FruitsItemModel>
}