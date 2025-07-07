package com.afahmi.lokamedan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExploreAdapter(
    private val list: List<WisataModel>,
    private val onItemClick: (WisataModel) -> Unit
) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.exploreGambar)
        val nama: TextView = itemView.findViewById(R.id.exploreNama)
        val lokasi: TextView = itemView.findViewById(R.id.exploreLokasi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_explore_card, parent, false)
        return ExploreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        val data = list[position]
        holder.img.setImageResource(data.gambar)
        holder.nama.text = data.nama
        holder.lokasi.text = data.lokasi

        holder.itemView.setOnClickListener {
            onItemClick(data)
        }
    }

    override fun getItemCount(): Int = list.size
}
