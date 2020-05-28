package com.example.ecommerceappkotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var sharedPref : SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        large_radioButton.setOnClickListener {
//
//            text.setTextSize(50f);
//        }
//        medium_radioButton.setOnClickListener {
//            text.setTextSize(25f);
//        }
//        small_radioButton2.setOnClickListener {
//            text.setTextSize(10f);
//        }
//        large_radioButton.setOnClickListener {  SELECT setOnclickListener with the curly braces
//
//        }

        //--------------------------------------------------------------------------------SHARED PREFERENCES------------------------------------------------------------------------------------------------------
        //sharedPreferances is a file where we want to store data that can be shared or used by others
        //where the data is not confidential
//        btnAdd.setOnClickListener {
//
//            //initialising the shared preferences object to be private for this application no one else can use this object
//            sharedPref=getSharedPreferences("addData", Context.MODE_PRIVATE) //1st arg=key of the shared preference which should be unique 2nd is to specify whether we want to keep the shared preferences object to be private or public ie which can be used by other applications as well
//            //editor does the job of editing data to the sharedpreference object
//            var myEditor=sharedPref?.edit()
//            //we are going to use myEditor to write data on sharedPref File
//            myEditor?.putString("product_name",edtProduct.text.toString()) //product_name is the key here
//            myEditor?.commit()
//            Toast.makeText(applicationContext,"Product saved",Toast.LENGTH_SHORT).show()
//
//
//        }
//        //after saving the data in sharedPreferences file , we wanna read it too
//        btnGetProduct.setOnClickListener {
//            txtGetProduct.text=sharedPref?.getString("product_name","nothing to show") //first arguement is the key used in putString,second arg is default value if there is nothing to show
//        }
        //---------------------------------------------------------------------------------SHARED PREFERENCES---------------------------------------------------------------------------------------------------

        btnGetData.setOnClickListener {

            val serverUrl: String="http://192.168.2.102/PHPTest/test_file.php"
            val requestQ: RequestQueue=Volley.newRequestQueue(applicationContext) //making request so as to get the data from the server
            //now we have to get the data from the server
            //in our server there is a string value and in order to get that we need to make a string variable
            var stringRequest= StringRequest(Request.Method.GET,serverUrl, Response.Listener { response ->


                /*Method StringRequest takes 3 args
                * the first one is how you wanna get the data
                * getting data from GET method is simple but not secured
                * getting data via POST method is not so simple
                * but most secured
                * The second One is the server url
                * The third one is response listener and inside that we have to type response
                * in lower case and select the first option
                * this whole block of got will show error if Response.ErrorListener is not called
                * and inside that we need to type error in lower case and select the
                * first option*/


                txtHelloWorld.text=response






            },Response.ErrorListener { error ->

                txtHelloWorld.text=error.message


            })
            //adding the string request to the request queue
            requestQ.add(stringRequest)



        }

    }
}


