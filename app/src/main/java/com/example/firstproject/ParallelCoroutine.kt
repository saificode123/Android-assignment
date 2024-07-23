package com.example.firstproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstproject.databinding.ActivityParallelCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ParallelCoroutine : AppCompatActivity() {
    var binding: ActivityParallelCoroutineBinding? = null
    private var job1: Job? = null
    private var job2: Job? = null
    private var isRunning1 = false
    private var isRunning2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParallelCoroutineBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        fun startCoroutine1() {
            job1 = CoroutineScope(Dispatchers.Main).launch {
                isRunning1 = true
                for (i in 1001 downTo 1) {
                    delay(500)
                    binding?.Counter1?.text = i.toString()
                }
                isRunning1 = false
            }
        }

        fun startCoroutine2() {
            job2 = CoroutineScope(Dispatchers.Main).launch {
                isRunning2 = true
                for (i in 0..100) {
                    delay(1000)
                    binding?.Counter2?.text = i.toString()
                }
                isRunning2 = false
            }
        }

        fun stopCoroutine() {
            job1?.cancel()
            job2?.cancel()
            isRunning1 = false
            isRunning2 = false
        }

        binding?.btnStart?.setOnClickListener()
        {
            startCoroutine1()
            startCoroutine2()
        }

        binding?.btnStop?.setOnClickListener()
        {
            if (isRunning1)
                stopCoroutine()
            if (isRunning2)
                stopCoroutine()
        }
    }
}