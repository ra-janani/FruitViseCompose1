package com.example.fruityvisecompose1.remote

import com.example.fruityvisecompose1.data.FruitsItemModel
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.BASE_URL)
    suspend fun getFruits(): ArrayList<FruitsItemModel>
}