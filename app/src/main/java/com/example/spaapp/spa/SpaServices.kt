package com.example.spaapp.spa

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpaService constructor(
    private val webservice: SpaWebService
) {
    fun getRandomDog(onDone: (Doggo)->Unit, onError: (Throwable)->Unit ) {
        //Appel la requête HTTP
        webservice.getRandomDog().enqueue(object : Callback<Array<Doggo>> {
            //Quand la requête est terminée
            override fun onResponse(
                call: Call<Array<Doggo>>,
                response: Response<Array<Doggo>>
            ) {
                val spaResponse =  response.body()
                val adog = spaResponse!![0]
                onDone(adog)
            }
            override fun onFailure(call: Call<Array<Doggo>>, t: Throwable) {
                onError(t)
            }
        })
    }
}