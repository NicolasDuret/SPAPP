package com.example.spaapp.Spa

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SpaWebService{
    @GET( "/v1/images/search?limit=10&order=Desc")
    @Headers("x-api-key: fd1b78f9-d6ca-41d5-a299-077a45077f27")
    fun getRandomSpa(): Call<SpaResponse>
}