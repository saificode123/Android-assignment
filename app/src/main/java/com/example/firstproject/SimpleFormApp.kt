package com.example.firstproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstproject.databinding.ActivitySimpleFormAppBinding

class SimpleFormApp : AppCompatActivity() {
    var binding:ActivitySimpleFormAppBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySimpleFormAppBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnSave?.setOnClickListener()
        {
            val name=binding?.name?.text.toString().trim()
            val email=binding?.email?.text.toString().trim()
            val phone=binding?.phone?.text.toString().trim()

            binding?.Viewname?.text="Name $name"
            binding?.Viewemail?.text="Email $email"
            binding?.Viewphone?.text="Phone $phone"
        }
    }
}