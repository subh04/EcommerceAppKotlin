package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_all_json_objects.*

class ShowAllJsonObjects : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_json_objects)
        txtAllProducts.setOnClickListener {
            val allProductsURL="http://192.168.2.102/Ecommerce/present_json_array.php"
            //WE CREATE A VARIABLE TO HOLD ALL THE PRODUCTS
            var allProductsString:String=""
            val requestQ:RequestQueue=Volley.newRequestQueue(applicationContext)
            //we want get an  array from the server
            val jsonArrayaRequest=JsonArrayRequest(Request.Method.GET,allProductsURL,null,Response.Listener { response ->

                //iterate over all of the products and showing them on the users device
                for (productIndex in 0.until(response.length())){
                    //this is one way to get all the values
//                    allProductsString=allProductsString+response.getJSONObject(productIndex).getString("name")+
//                            " - "+response.getJSONObject(productIndex).getString("price")

                    var productName=response.getJSONObject(productIndex).getString("name")
                    var productPrice=response.getJSONObject(productIndex).getInt("price")
                    allProductsString=allProductsString+ productName + " - " + productPrice + "\n"

                }
                txtAllProducts.text=allProductsString




            },Response.ErrorListener { error ->

                txtAllProducts.text=error.message




            })

            requestQ.add(jsonArrayaRequest)

        }
    }
}
