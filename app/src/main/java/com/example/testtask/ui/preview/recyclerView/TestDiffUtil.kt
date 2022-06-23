package com.example.testtask.ui.preview.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.example.testtask.data.models.Data

class TestDiffUtil(
    private val oldList: ArrayList<Data>,
    private val newList: ArrayList<Data>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id


}