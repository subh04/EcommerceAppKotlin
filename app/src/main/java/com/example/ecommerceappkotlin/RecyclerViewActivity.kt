package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var myProductList=ArrayList<EProducts>()
        myProductList.add(EProducts(0,"mango",1000,R.drawable.mango))
        myProductList.add(EProducts(1,"chiku",1000,R.drawable.chiku))
        myProductList.add(EProducts(2,"grapes",1000,R.drawable.grapes))
        myProductList.add(EProducts(3,"banana",1000,R.drawable.banana))
        myProductList.add(EProducts(4,"pineapple",1000,R.drawable.pineapple))
        myProductList.add(EProducts(5,"apple",1000,R.drawable.apple))

        var recyclerViewAdapter=RecyclerView_Adapter(this@RecyclerViewActivity,myProductList)
        //objects are below each other vertically
        recyclerView.layoutManager=LinearLayoutManager(this@RecyclerViewActivity)
        recyclerView.adapter=recyclerViewAdapter



    }
}
