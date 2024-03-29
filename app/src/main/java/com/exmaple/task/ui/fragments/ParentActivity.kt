package com.exmaple.task.ui.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmaple.task.databinding.ActivityParentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityParentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityParentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}