package com.example.testtask.ui.preview.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtask.data.models.Data
import com.example.testtask.databinding.ItemBinding

class Adapter(val clickListener : (data : Data) -> Unit) : RecyclerView.Adapter<Adapter.Holder>() {

    private val oldList: ArrayList<Data> = arrayListOf()

    inner class Holder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.image.resizeImage(oldList[bindingAdapterPosition].images?.original?.url)
            binding.gifId.text = oldList[bindingAdapterPosition].title
            binding.root.setOnClickListener {
                clickListener(oldList[bindingAdapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: ItemBinding =
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = oldList.size

    fun setData(newList: ArrayList<Data>) {
        val diffUtil = TestDiffUtil(oldList, newList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        oldList.clear()
        oldList.addAll(newList)
        diffResults.dispatchUpdatesTo(this)
    }

    fun ImageView.resizeImage(imagePath: String?) {
        this.layout(0,0,0,0)
        Glide.with(context.applicationContext)
            .load(imagePath)
            .fitCenter()
            .centerCrop()
            .into(this)
    }

}