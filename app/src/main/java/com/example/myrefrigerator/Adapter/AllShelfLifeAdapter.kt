package com.example.myrefrigerator.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrefrigerator.R
import com.example.myrefrigerator.data.AllShelfLifeListView
import java.util.*

class AllShelfLifeAdapter(val context: Context, private val list:ArrayList<AllShelfLifeListView>) :
    RecyclerView.Adapter<AllShelfLifeAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_listview, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(list[position], context)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val Name = itemView?.findViewById<TextView>(R.id.listxml_foodName)
        val ShelfLife = itemView?.findViewById<TextView>(R.id.listxml_foodAllShelfLife)
        val Img = itemView?.findViewById<ImageView>(R.id.listxml_foodImageView)

        fun bind(listView: AllShelfLifeListView, context: Context) {
            /* 나머지 TextView와 String 데이터를 연결한다. */
            Img?.setImageDrawable(listView.foodImage)
            Name?.text = listView.afoodName
            ShelfLife?.text = listView.afoodAllShelfLife
        }
    }
}