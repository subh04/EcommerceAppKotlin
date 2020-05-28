package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        large_radioButton.setOnClickListener {

            text.setTextSize(50f);
        }
        medium_radioButton.setOnClickListener {
            text.setTextSize(25f);
        }
        small_radioButton2.setOnClickListener {
            text.setTextSize(10f);
        }
//        large_radioButton.setOnClickListener {  SELECT setOnclickListener with the curly braces
//
//        }

    }
}
