package com.example.spaapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.example.spaapp.spa.DoggoFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cards = 20
        for (cardIndex in 1..cards) {
            val dogFragment = DoggoFragment()
            supportFragmentManager.beginTransaction().add(
                listbox.id, dogFragment
            ).commit()
        }
        //tests


        //   findViewById<Button>(R.id.done_button).setOnClickListener {
        //appel de la fun() qui inflate la vue suivante
        //  }

    }
    fun nextActivity(view : View) {
        val intent = Intent(this, DoggoDescription::class.java)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
