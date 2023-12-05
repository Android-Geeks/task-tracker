package com.example.tasktracker.data.data_source.remote.response


import com.google.gson.annotations.SerializedName

data class AppDataResponse(
    @SerializedName("results")
    val response: String
)