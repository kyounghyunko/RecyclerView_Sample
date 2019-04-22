package com.example.recylerview_sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager



class MainActivity : AppCompatActivity() {

    private val names: ArrayList<String> = arrayListOf("Charlie","Andrew","Han","Liz","Thomas","Sky","Andy","Lee","Park")

    private val mItems: ArrayList<RecyclerItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Loads animals into the ArrayList
        addItems()
        // Activity 에서 kotlin extensions을 사용하여 별도의 findViewById 없이 View를 사용할 수 있습니다.
        recycler_view.adapter = CustomRecyclerAdapter(mItems, this)
        // 다양한 LayoutManager 가 있습니다. 원하시는 방법을 선택해주세요.
        // 지그재그형의 그리드 형식
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        // 그리드 형식
        //recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        // 가로 또는 세로 스크롤 목록 형식
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    private fun addItems() {
        mItems.clear()
        // RecyclerViewに入るデータを追加
        for (name in names) {
            mItems.add(RecyclerItem(name))
        }
        // 데이터 추가가 완료되었으면 notifyDataSetChanged() 메서드를 호출해 데이터 변경 체크를 실행합니다.
        recycler_view.adapter?.notifyDataSetChanged()
    }
}
