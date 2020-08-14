package com.example.teste_kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_rv.view.*

class AdapterPlaneta(val listaDePlanetas: MutableList<Planeta>, val planetaListener: PlanetaListener):
    RecyclerView.Adapter<AdapterPlaneta.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_rv, parent, false)
        return MyViewHolder(item, planetaListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val planeta = listaDePlanetas[position]

        holder.tv_nome.text = planeta.nome
    }

    override fun getItemCount(): Int {
        return listaDePlanetas.size
    }

    class MyViewHolder(itemView: View, val planetaListener: PlanetaListener): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val tv_nome: TextView = itemView.tv_nome

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            planetaListener.planetaClick(adapterPosition)
        }
    }

    interface PlanetaListener {
        fun planetaClick(position: Int)
    }

}