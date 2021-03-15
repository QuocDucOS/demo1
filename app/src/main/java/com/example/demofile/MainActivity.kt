package com.example.demofile

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var txt: TextView
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        anhxa()
        click()
        readFile()
    }

    private fun click() {
        txt.setOnClickListener(this)
        btn.setOnClickListener(this)
    }

    private fun anhxa() {
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        txt = findViewById(R.id.txt2)
        btn = findViewById(R.id.btn1)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn1 -> {
                val str1 = this.edt1.text.toString()
                val str2 = this.edt2.text.toString()
                if (str1.isEmpty() || str2.isEmpty()) {
                    Toast.makeText(this, "nhập lại", Toast.LENGTH_LONG).show()
                } else {
                    val shr = getSharedPreferences("share", Context.MODE_PRIVATE)
                    val saveUser = shr.getString("username", null)
                    val savePass = shr.getString("password", null)
                    if (savePass.equals(str2) && saveUser.equals(str1)) {
                        val intt = Intent(this, MainActivity3::class.java)
                        startActivity(intt)
                    } else {
                        //val intt = Intent(this,R.layout.dialog::class.java)
                        //intt.putExtra("chuoi1", str1)
                        //intt.putExtra("chuoi2", str2)
                       // startActivity(intt)
                      Dialoggg()
                    }

                }
            }
        }
    }

    private fun readFile() {
        val shr = getSharedPreferences("share", Context.MODE_PRIVATE)
        val saveUser = shr.getString("username", null)
        val savePass = shr.getString("password", null)
        edt1.setText(saveUser)
        edt2.setText(savePass)
    }
    private fun Dialoggg(){
        val dig=Dialog(this)
        dig.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dig.setContentView(R.layout.dialog)
       // dig.setCanceledOnTouchOutside(false)
        val txt1=dig.findViewById<TextView>(R.id.txt2)
        val txt2=dig.findViewById<TextView>(R.id.txt3)
      //  val str1 = this.edt1.text.toString()
      //  val str2 = this.edt2.text.toString()
        txt1.setOnClickListener{
            try {
                saveFile()
                val intt = Intent(this, MainActivity3::class.java)
                startActivity(intt)
            } catch (e: IOException) {
                Toast.makeText(this, "not save", Toast.LENGTH_SHORT).show()
            }
        }
        txt2.setOnClickListener{
           // dig.cancel()
            val intt = Intent(this, MainActivity3::class.java)
            startActivity(intt)
        }
        dig.show()
    }
    private fun saveFile() {
        //val intt = intent
       // val str1: String = intt.getStringExtra("chuoi1").toString()
       // val str2: String = intt.getStringExtra("chuoi2").toString()
        val str1 = this.edt1.text.toString()
        val str2 = this.edt2.text.toString()
        val shr = getSharedPreferences("share", Context.MODE_PRIVATE)
        val edt = shr.edit()
        edt.apply {
            edt.putString("username", str1)
            edt.putString("password", str2)
        }.apply()
        // edt.commit()
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()
    }
}