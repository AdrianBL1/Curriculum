package com.adrianbl.curriculum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(DatosPersonales())
        bottomNav = findViewById(R.id.bottomNavigationView) as BottomNavigationView

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.datos_p -> {
                    loadFragment(DatosPersonales())
                    true
                }
                R.id.formacion-> {
                    loadFragment(Formacion())
                    true
                }
                R.id.datos_i -> {
                    loadFragment(DatosInteres())
                    true
                }

                else -> false
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flFragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}