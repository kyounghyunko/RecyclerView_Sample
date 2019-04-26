package com.example.recylerview_sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager



class MainActivity : AppCompatActivity() {

    private val names: ArrayList<String> = arrayListOf("Charlie","Andrew","Han","Liz","Thomas","Sky","Andy","Lee","Park", "坂本", "稲森", "渡辺", "吉田", "櫻井")

    private val mItems: ArrayList<RecyclerItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Loads animals into the ArrayList
        addItems()
        // Activityでkotlin extensionsを私用してfindViewByIdなくともViewの呼び出しができる
        recycler_view.adapter = CustomRecyclerAdapter(mItems, this)
        // recyclerviewはいろいろなLayoutManagerがある
        // ジグザグのグリッド形式
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        // 普通のグリッド形式
        //recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        // 横又は縦のスクロール形式
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    private fun addItems() {
        mItems.clear()
        // RecyclerViewに入るデータを追加
        for (name in names) {
            mItems.add(RecyclerItem(name))
        }
        // データ追加が完了したらnotifyDataSetChangedメソッドを呼び出して更新する
        recycler_view.adapter?.notifyDataSetChanged()
    }
}
