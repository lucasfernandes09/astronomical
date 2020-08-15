package com.example.teste_kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_rv_h.view.*

class AdapterPlaneta2(val listaDePlanetas: MutableList<Planeta>, val planetaListener: PlanetaListener):
    RecyclerView.Adapter<AdapterPlaneta2.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_rv_h, parent, false)
        return MyViewHolder(item, planetaListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val planeta = listaDePlanetas[position]

        holder.tv_nome2.text = planeta.nome
        holder.iv_icon2.setImageResource(planeta.icon)
    }

    override fun getItemCount(): Int {
        return listaDePlanetas.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class MyViewHolder(itemView: View, val planetaListener: PlanetaListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val tv_nome2: TextView = itemView.tv_nome2
        val iv_icon2: ImageView = itemView.iv_icon2

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
