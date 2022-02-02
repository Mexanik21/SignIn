package com.example.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.view.R
import com.example.view.model.Member

class MainAdapter(private val members:List<Member>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members.get(position)

        if(holder is MainViewHolder){

        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class MainViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){

        val text1 = itemView.findViewById<TextView>(R.id.txt1)
        val text2 = itemView.findViewById<TextView>(R.id.txt2)
    }
}