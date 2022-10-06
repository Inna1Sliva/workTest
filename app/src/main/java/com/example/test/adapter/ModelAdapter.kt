package com.example.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.model.Model

class ModelAdapter(val listModel:ArrayList<Model>):RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {
   var onItemClick:((Model)->Unit)? = null
    class ModelViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var image : ImageView = view.findViewById(R.id.image)
        //var drscritionOne : TextView = view.findViewById(R.id.sale_text)
        var titleText : TextView = view.findViewById(R.id.textTitle)
        var data: TextView = view.findViewById(R.id.dataTitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent,false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val list = listModel[position]
        holder.image.setImageResource(list.image)
        holder.titleText.text = list.title
        holder.data.text=list.data
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list)

        }
    }

    override fun getItemCount(): Int {
        return listModel.size
    }
}