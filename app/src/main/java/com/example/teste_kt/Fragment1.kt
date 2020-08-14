package com.example.teste_kt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*

class Fragment1 : Fragment() , AdapterPlaneta.PlanetaListener {
    val listaDePlanetas = mutableListOf<Planeta>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("infoF", "onCreate fragment1")

        if(listaDePlanetas.isEmpty()) initPlanetas()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        Log.i("infoF", "onCreateView fragment1")

        exibirRecyclerView(view)

        return view
    }

    private fun exibirRecyclerView(view: View) {
        val adapterPlaneta = AdapterPlaneta(listaDePlanetas, this)
        val recyclerView = view.recyclerView
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapterPlaneta

    }

    fun initPlanetas() {
        listaDePlanetas.add(Planeta("Mercúrio"))
        listaDePlanetas.add(Planeta("Vênus"))
        listaDePlanetas.add(Planeta("Terra"))
        listaDePlanetas.add(Planeta("Marte"))
        listaDePlanetas.add(Planeta("Júpiter"))
        listaDePlanetas.add(Planeta("Saturno"))
        listaDePlanetas.add(Planeta("Urano"))
        listaDePlanetas.add(Planeta("Netuno"))
    }

    override fun planetaClick(position: Int) {
        val intent = Intent(context, PlanetaActivity::class.java)
        intent.putExtra("planeta", listaDePlanetas[position])
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.i("infoF", "onStart fragment1")
    }

    override fun onResume() {
        super.onResume()
        Log.i("infoF", "onResume fragment1")
    }

    override fun onPause() {
        super.onPause()
        Log.i("infoF", "onPause fragment1")
    }

    override fun onStop() {
        super.onStop()
        Log.i("infoF", "onStop fragment1")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("infoF", "onDestroyView fragment1")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("infoF", "onDestroy fragment1")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("infoF", "onDetach fragment1")
    }


}