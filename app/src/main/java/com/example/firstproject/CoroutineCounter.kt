package com.example.firstproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstproject.databinding.ActivityCoroutineCounterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineCounter : AppCompatActivity() {
    private var job: Job?=null
    private var isRunning=false
    var binding:ActivityCoroutineCounterBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCoroutineCounterBinding.inflate(layoutInflater)
        setContentView(binding?.root)

       fun startCoroutine()
       {
           job= CoroutineScope(Dispatchers.Main).launch {
            isRunning=true
               for(i in 1..100){
                   delay(1000)
                   binding?.View?.text=i.toString()
               }
               isRunning=false
           }
       }

        fun stopCoroutine()
        {
            job?.cancel()
            isRunning=false
        }

        binding?.btnStart?.setOnClickListener()
        {
            startCoroutine()
        }
        binding?.btnStop?.setOnClickListener()
        {
            if(isRunning)
                stopCoroutine()
        }

    }
}