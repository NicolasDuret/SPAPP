package com.example.spaapp.spa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spaapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.doggo_fragment.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DoggoFragment : Fragment() {
    companion object {
        fun newInstance() = DoggoFragment()
    }

    //Affiche l'interface graphique
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this doggo_fragment
        val view = inflater?.inflate(R.layout.doggo_fragment, container, false)
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.thedogapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(SpaWebService::class.java)
        val SpaService = SpaService(retrofitService)

        SpaService.getRandomDog(
            { adog ->
                Picasso.get().load(adog.url).into(view.DoggoImage)
                view.DoggoName.text = adog.id
            }, { error ->
                throw error
            }
        )
    }

}