package com.example.spaapp.Spa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spaapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpaFragment : Fragment() {
    companion object {
        fun newInstance() = SpaFragment()
    }

    //Affiche l'interface graphique
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.fragment, container, false)
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
        val cocktailService = SpaService(retrofitService)

        cocktailService.getRandomSpa(
            { cocktail ->
                Picasso.get().load(cocktail.strSearchThumb).into(view.SpaImage)
                view.SpaName.text = cocktail.strSearch
            }, { error -> TODO() }
        )
    }

}