package com.kyura.myproject1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListPlayerAdapter(private val listPlayer: ArrayList<Player>) : RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPlayerAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_players, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListPlayerAdapter.ListViewHolder, position: Int) {
        val (name, status, photo, position, detail) = listPlayer[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.imgPhoto) // imageView mana yang akan diterapkan
        holder.tvName.text = name
        holder.tvStatus.text = status

        val details = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(details, PlayerDetail::class.java)
            moveDetail.putExtra(PlayerDetail.EXTRA_NAME, name)
            moveDetail.putExtra(PlayerDetail.EXTRA_PHOTO, photo)
            moveDetail.putExtra(PlayerDetail.EXTRA_POSITION, position)
            moveDetail.putExtra(PlayerDetail.EXTRA_DETAIL, detail)
            details.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int = listPlayer.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvStatus: TextView = itemView.findViewById(R.id.tv_item_status)
    }
}