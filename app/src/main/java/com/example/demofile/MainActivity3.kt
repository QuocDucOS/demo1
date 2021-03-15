package com.example.demofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity3 : AppCompatActivity(), View.OnClickListener {
    //private lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
     //   val intt= Intent(this,MainActivity::class.java)
      //  startActivity(intt)
       // btn=findViewById(R.id.btn2)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn2->{
                val intt=Intent(this,MainActivity::class.java)
                startActivity(intt)
            }
        }
    }
}