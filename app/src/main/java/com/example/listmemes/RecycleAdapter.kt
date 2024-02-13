package com.example.listmemes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listmemes.data.Meme
import com.example.listmemes.databinding.MemesAdapterBinding

class RecyclerAdapter(): RecyclerView.Adapter<RecyclerAdapter.ListMemesViewHolder>() {

    private val adapterList = mutableListOf<Meme>()


    inner class ListMemesViewHolder(private var binding: MemesAdapterBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(item: Meme){
            binding.nameMem.text = item.name

            Glide
                .with(binding.root.context)
                .load(item.url)
                .into(binding.imageMem)


        }
    }


    fun submitList(list: List<Meme>){
        adapterList.addAll(list)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.ListMemesViewHolder {
        return ListMemesViewHolder(
            MemesAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ListMemesViewHolder, position: Int) {
      holder.onBind(adapterList[position])
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }
}