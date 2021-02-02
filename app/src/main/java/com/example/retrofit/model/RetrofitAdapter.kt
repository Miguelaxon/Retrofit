package com.example.retrofit.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ItemJsonBinding

class RetrofitAdapter: RecyclerView.Adapter<RetrofitAdapter.TerrMarsViewHolder>() {
    private var mList = listOf<TerraMars>()
    private var selected = MutableLiveData<TerraMars>()

    fun selected():LiveData<TerraMars> = selected

    fun update(list: List<TerraMars>){
        mList = list
        notifyDataSetChanged()
    }
    inner class TerrMarsViewHolder(private val binding: ItemJsonBinding):
    RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(terraMars: TerraMars) {
            Glide.with(binding.root).load(terraMars.imgSrc).into(binding.imageView2)
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            selected.value = mList[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerrMarsViewHolder {
        return TerrMarsViewHolder(ItemJsonBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: TerrMarsViewHolder, position: Int) {
        val terraMars = mList[position]
        holder.bind(terraMars)
    }
}