package com.android.example.memoapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.memoapp.databinding.ItemRecyclerviewBinding
import com.android.example.memoapp.model.Memo

class MemoAdapter : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    private var memoList = emptyList<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(memoList[position])
    }

    override fun getItemCount() = memoList.size

    fun setData(memo: List<Memo>) {
        memoList = memo
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: Memo) {
            val currentId = currentItem.id.toString()
            val currentTitle = currentItem.title
            val currentContent = currentItem.content

            with(binding) {
                tvId.text = currentId
                tvContent.text = currentContent
                tvTitle.text = currentTitle
                itemLayout.setOnClickListener {
                    val intent = Intent(it.context, UpdateActivity::class.java)
                    intent.putExtra("currentId", currentId)
                    intent.putExtra("currentTitle", currentTitle)
                    intent.putExtra("currentContent", currentContent)
                    it.context.startActivity(intent)
                }
            }
        }
    }
}