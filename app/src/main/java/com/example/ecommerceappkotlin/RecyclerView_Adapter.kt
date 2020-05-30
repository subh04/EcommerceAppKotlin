package com.example.ecommerceappkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerView_Adapter(var context:Context,var arrayList: ArrayList<EProducts>):    //class with primary constructor
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {        //parent is going to hold the items
        //whenever we want to add items in the listView this method is being called
        //for each item onCreateViewHolder is called
        var productView=LayoutInflater.from(context).inflate(R.layout.rv_row,parent,false) //in order to get the context from primary constructor of the class we need to add the var keyword before the paramaeter of the primary constructor
                                                                                                        //context is used to access the references outside of the activity
                                                                                                        //false cz the items are already attatched to the recycler view
        return productViewHolder(productView)
        //productViewHolder is implemented from recyclerView.ViewHolder and takes parameter of type View


    }

    override fun getItemCount(): Int {
        //return total number of items in the list
        return arrayList.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //shows data at specific position
        (holder as productViewHolder).initializeUIComponents(arrayList[position].id,
            arrayList[position].name,
            arrayList[position].price,
            arrayList[position].productPic)               //as productViewHolder is also an RecyclerView.ViewHolder
                                                          //arrayList Only holds EProducts
                                                            //int this way it is going to initialise the UIComponents



    }
    inner class productViewHolder(myView:View):
            RecyclerView.ViewHolder(myView){

        var pID=myView.findViewById<TextView>(R.id.productId)
        var pName=myView.findViewById<TextView>(R.id.productName)
        var pPic=myView.findViewById<ImageView>(R.id.productImage)
        var pPrice=myView.findViewById<TextView>(R.id.productPrice)
        //initialising the ui components
        fun initializeUIComponents(pid:Int,pname:String,pprice:Int,ppic:Int){

            pID.text=pid.toString()
            pName.text=pname
            pPrice.text=pprice.toString()
            pPic.setImageResource(ppic)

        }


    }

}

//recycler view is just like list view which is more efficient and fast
//Whenever your listview is filled by an adapter it basically shows the
// number of Rows that the listview can show on screen and the number of
// rows doesn't increase even when you scroll through the list. This is
// the trick android uses so that listview works more efficiently and fast.