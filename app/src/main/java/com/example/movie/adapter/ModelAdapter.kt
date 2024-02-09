package com.example.movie.adapter

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.databinding.ItemRvBinding
import com.example.movie.models.Model

class ModelAdapter(var rvAction: RvAction, var context: Context, var list:ArrayList<Model>): RecyclerView.Adapter<ModelAdapter.Vh>() {
    inner class Vh(private var itemRvBinding: ItemRvBinding): RecyclerView.ViewHolder(itemRvBinding.root){
        fun onBind(model: Model, position: Int){
            itemRvBinding.kinoNomi.text = model.kinoNomi
            itemRvBinding.date.text = model.date
            itemRvBinding.mualiflar.text = model.aktiyor

            itemRvBinding.root.setOnClickListener {
                rvAction.myItemClick(model,position)
            }
            itemRvBinding.btnDelete.setOnClickListener {
                rvAction.itemView(position)
            }
            itemRvBinding.btnEdt.setOnClickListener {
                rvAction.itemEdit(model,position)
            }
            Log.d(TAG, "onBind: $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    interface RvAction {
        fun myItemClick(model: Model,position: Int)
        fun itemView(position: Int)
        fun itemEdit(model: Model,position: Int)
    }
}