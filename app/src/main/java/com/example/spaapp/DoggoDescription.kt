package com.example.spaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.spaapp.spa.Doggo
import com.google.gson.Gson
import android.app.Activity

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DoggoDescription.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DoggoDescription.newInstance] factory method to
 * create an instance of this fragment.
 */
class DoggoDescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_doggo_description)
    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doggo_description, container, false)
    }*/



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DoggoDescription.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = DoggoDescription()

    }





    }
