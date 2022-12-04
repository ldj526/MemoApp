package com.android.example.memoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.memoapp.databinding.ItemRecyclerviewBinding
import com.android.example.memoapp.model.Memo

class MemoAdapter : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    private var memoList = emptyList<Memo>()

    class ViewHolder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = memoList[position]
        holder.binding.tvContent.text = currentItem.content
        holder.binding.tvTitle.text = currentItem.title
    }

    override fun getItemCount() = memoList.size

    fun setData(memo: List<Memo>) {
        memoList = memo
        notifyDataSetChanged()
    }
}