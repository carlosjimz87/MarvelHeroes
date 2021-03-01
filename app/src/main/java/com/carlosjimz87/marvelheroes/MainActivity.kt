package com.carlosjimz87.marvelheroes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.carlosjimz87.marvelheroes.databinding.MainActivityBinding
import com.carlosjimz87.marvelheroes.models.Hero
import com.carlosjimz87.marvelheroes.ui.list.ListFragment


class MainActivity : AppCompatActivity() {

    private var dummyHeroes: List<Hero> = listOf(
        Hero("A-BOMB","https://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16/landscape_incredible.jpg"),
        Hero("3d-MAN","https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/landscape_incredible.jpg"),
        Hero("AARON STACK","https://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available/landscape_incredible.jpg"),
        Hero("ABOMINATION","https://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04/landscape_incredible.jpg"),
        Hero("ABSORBING MAN","https://i.annihil.us/u/prod/marvel/i/mg/1/b0/5269678709fb7/landscape_incredible.jpg"),
        Hero("ABYSS","https://i.annihil.us/u/prod/marvel/i/mg/9/30/535feab462a64/landscape_incredible.jpg")
    )


    private lateinit var binding: MainActivityBinding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setCustomView( R.layout.custom_toolbar)
        supportActionBar!!.elevation = 0f

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ListFragment(dummyHeroes))
                    .commitNow()
        }


    }
}