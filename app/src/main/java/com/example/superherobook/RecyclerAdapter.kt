package com.example.superherobook

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerAdapter(val superHeroList: ArrayList<String>, val superHeroImages : ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.SuperHeroVH>() {
    class SuperHeroVH(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroVH {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return SuperHeroVH(itemView)
    }

    override fun getItemCount(): Int {
        print(superHeroList.size)
        return superHeroList.size
    }

    override fun onBindViewHolder(holder: SuperHeroVH, position: Int) {
       var textView = holder.itemView.findViewById<TextView>(R.id.recyclerViewTextView)
        textView.text = superHeroList.get(position)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, TanitimActivity::class.java)
            intent.putExtra("superHeroName", superHeroList.get(position))
            /*val singleton = SingletonClass.SelectedHero
            singleton.gorsel = superHeroImages.get(position)*/
            intent.putExtra("superHeroImage", superHeroImages.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }
}