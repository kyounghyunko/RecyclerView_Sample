package com.example.recylerview_sample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_recycler_view.view.*
import android.widget.Toast

class CustomRecyclerAdapter(val items: ArrayList<RecyclerItem>, val context: Context): RecyclerView.Adapter<CustomRecyclerAdapter.ItemViewHolder>() {

    // 新しいビューホルダー生成
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomRecyclerAdapter.ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, p0, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // ホルデーにデータをバインディング
    override fun onBindViewHolder(p0: CustomRecyclerAdapter.ItemViewHolder, p1: Int) {
        p0.view.itemNameTv.text = items[p1].getItemName()
        // クリックリスナー追加、クリックしたらトストで名前が出る
        p0.view.setOnClickListener {
            Toast.makeText(context, items[p1].getItemName(), Toast.LENGTH_SHORT).show()
        }
    }

    // カスタムビューホルダー
    // item layoutにある部品をバインディングする
    class ItemViewHolder(val view: View) : ViewHolder(view) {

        private var nameTextView: TextView? = null

        init {
            nameTextView = view.findViewById(R.id.itemNameTv)
        }

    }
}