package com.example.spaapp.spa

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpaService constructor(
    private val webservice: SpaWebService
) {
    fun getRandomDog(onDone: (Doggo)->Unit, onError: (Throwable)->Unit ) {
        //Appel la requête HTTP
        webservice.getRandomDog().enqueue(object : Callback<SpaResponse> {
            //Quand la requête est terminée
            override fun onResponse(
                call: Call<Array<Doggo>>,
                response: Response<Array<Doggo>>
            ) {
                val spaResponse =  response.body()
                val doggo: Doggo = spaResponse!!.search[0]
                onDone(spa)
            }
            override fun onFailure(call: Call<SpaResponse>, t: Throwable) {
                onError(t)
            }
        })
    }
}