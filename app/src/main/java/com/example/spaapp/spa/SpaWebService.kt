package com.example.spaapp.spa

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SpaWebService{
    @GET( "/v1/images/search?limit=1")
    @Headers("x-api-key: fd1b78f9-d6ca-41d5-a299-077a45077f27")
    fun getRandomDog(): Call<Array<Doggo>>
}