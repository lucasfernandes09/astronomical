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

        setLayout(planeta)
    }

    fun setLayout(planeta: Planeta) {
        app_bar_image.setImageResource(planeta.img)
        tv_nome.text = planeta.nome
        tv_dm.text = planeta.diametro
        tv_m.text = planeta.massa
        tv_d.text = planeta.distanciaSol
        tv_ano.text = planeta.anoTerrestre
        tv_dia.text = planeta.diaTerrestre
    }

}