package com.carlosjimz87.marvelheroes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.carlosjimz87.marvelheroes.ui.list.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ListFragment.newInstance())
                    .commitNow()
        }
    }
}