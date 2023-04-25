package com.example.fruityvisecompose.data


import com.google.gson.annotations.SerializedName

data class FruitsItemModel(
    @SerializedName("family")
    val family: String? = "",
    @SerializedName("genus")
    val genus: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("nutritions")
    val nutritions: NutritionsModel? = NutritionsModel(),
    @SerializedName("order")
    val order: String? = ""
)