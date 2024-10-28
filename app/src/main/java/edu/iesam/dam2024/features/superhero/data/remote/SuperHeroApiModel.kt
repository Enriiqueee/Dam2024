package edu.iesam.dam2024.features.superhero.data.remote

import com.google.gson.annotations.SerializedName

data class SuperHeroApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("images") val images: SuperHeroImageApiModel
)

data class SuperHeroImageApiModel(
    @SerializedName("md") val md: String
)

