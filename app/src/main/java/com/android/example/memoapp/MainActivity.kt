package com.android.example.memoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.android.example.memoapp.databinding.ActivityMainBinding
import com.android.example.memoapp.viewmodel.MemoViewModel
import com.android.example.memoapp.viewmodel.MemoViewModelFactory
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var memoViewModel: MemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        memoViewModel =
            ViewModelProvider(this, MemoViewModelFactory(application))[MemoViewModel::class.java]

        binding.btnFab.setOnClickListener {
            val intent = Intent(this, MemoWriteActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

        val adapter = MemoAdapter()
        binding.recyclerView.adapter = adapter
        memoViewModel.readAllData.observe(this, Observer {
            Collections.reverse(it)
            adapter.setData(it)
        })

    }
}