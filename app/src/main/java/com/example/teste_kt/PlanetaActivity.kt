package com.example.teste_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_planeta.*

class PlanetaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planeta)

        val planeta = intent.getParcelableExtra("planeta") as Planeta

        app_bar_image.setImageResource(planeta.img)
        tv_nome.text = planeta.nome
    }
}