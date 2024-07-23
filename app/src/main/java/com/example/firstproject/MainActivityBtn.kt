package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstproject.databinding.ActivityMainBtnBinding
import com.example.firstproject.databinding.ActivityUserSettingsAppBinding

class MainActivityBtn : AppCompatActivity() {
    var binding:ActivityMainBtnBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBtnBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.shared?.setOnClickListener()
        {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        binding?.DB?.setOnClickListener()
        {
            val intent=Intent(this,UserSettingsApp::class.java)
            startActivity(intent)
        }

        binding?.Coroutine?.setOnClickListener()
        {
            val intent=Intent(this,CoroutineCounter::class.java)
            startActivity(intent)
        }

        binding?.Parallel?.setOnClickListener()
        {
            val intent=Intent(this,ParallelCoroutine::class.java)
            startActivity(intent)
        }

        binding?.Submitform?.setOnClickListener()
        {
            val intent=Intent(this,SimpleFormApp::class.java)
            startActivity(intent)
        }
    }
}