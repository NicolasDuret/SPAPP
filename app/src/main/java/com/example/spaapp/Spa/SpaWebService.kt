package com.example.spaapp.Spa

import retrofit2.Call
import retrofit2.http.GET

interface SpaWebService{
    @GET( "/api/json/v1/1/random.php")
    fun getRandomSpa(): Call<SpaResponse>
}