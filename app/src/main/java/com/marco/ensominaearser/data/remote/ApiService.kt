package com.marco.ensominaearser.data.remote


import com.google.gson.JsonObject
import com.marco.ensominaearser.data.pojo.AiModelPost
import com.marco.ensominaearser.data.pojo.AiModelResponse
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
interface ApiService {
    @POST("predict")
     fun getResult(@Body information:RequestBody):Call<AiModelResponse>
}