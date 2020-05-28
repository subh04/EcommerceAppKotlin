package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_json_object.*

class ShowJsonObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_json_object)

        btnSubmit.setOnClickListener {

            val productURL:String="http://192.168.2.102/Ecommerce/present_json.php?id="+edtProductId.text.toString() //add ?id= in the end so user can enter the id
            val requestQ: RequestQueue=Volley.newRequestQueue(applicationContext)
            // WE WANT TO GET A JSON OBJECT
            val jsonObjectRequest=JsonObjectRequest(Request.Method.GET,productURL,null,Response.Listener { response ->  //json object request unlike string request takes 3 parameters


                txtProductName.text=response.getString("name")
                txtProductPrice.text=response.getInt("price").toString()





            },Response.ErrorListener { error ->


                txtProductName.text=error.message
                txtProductPrice.text=error.message




            })
            requestQ.add(jsonObjectRequest)

        }
    }
}
