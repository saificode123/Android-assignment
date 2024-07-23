package com.example.firstproject

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val sharedpre=getSharedPreferences("Pre_Name",Context.MODE_PRIVATE)
        val editor=sharedpre.edit()
        binding?.btnSave?.setOnClickListener()
        {
            editor.putString("name",binding?.name?.text.toString())
            editor.putString("age",binding?.age?.text.toString())
            editor.apply()
        }
        binding?.btnRe?.setOnClickListener()
        {
            binding?.rName?.setText(sharedpre.getString("name",""))
            binding?.rAge?.setText(sharedpre.getString("age",""))
        }

    }
}