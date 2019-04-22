package com.example.recylerview_sample

class RecyclerItem(val name: String) {

    private var mName = ""

    init {
        this.mName = name
    }

    fun getItemName(): String {
        return this.mName
    }
}