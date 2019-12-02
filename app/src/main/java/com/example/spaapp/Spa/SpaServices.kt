package com.example.spaapp.Spa

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpaService constructor(
    private val webservice: SpaWebService
) {
    fun getRandomSpa( onDone: (Spa)->Unit, onError: (Throwable)->Unit ) {
        //Appel la requête HTTP
        webservice.getRandomSpa().enqueue(object : Callback<SpaResponse> {
            //Quand la requête est terminée
            override fun onResponse(
                call: Call<SpaResponse>,
                response: Response<SpaResponse>
            ) {
                val spaResponse =  response.body()
                val spa: Spa = spaResponse!!.search[0]
                onDone(spa)
            }
            override fun onFailure(call: Call<SpaResponse>, t: Throwable) {
                onError(t)
            }
        })
    }
}