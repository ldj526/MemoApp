package com.android.example.memoapp

import android.os.Bundle
import android.text.TextUtils
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.example.memoapp.databinding.ActivityUpdateBinding
import com.android.example.memoapp.model.Memo
import com.android.example.memoapp.viewmodel.MemoViewModel
import com.android.example.memoapp.viewmodel.MemoViewModelFactory

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var memoViewModel: MemoViewModel
    private lateinit var currentTitle: String
    private lateinit var currentContent: String
    private var currentId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update)

        memoViewModel =
            ViewModelProvider(this, MemoViewModelFactory(application))[MemoViewModel::class.java]

        if (intent.hasExtra("currentTitle") && intent.hasExtra("currentContent")) {
            currentId = Integer.parseInt(intent.getStringExtra("currentId").toString())
            currentTitle = intent.getStringExtra("currentTitle").toString()
            currentContent = intent.getStringExtra("currentContent").toString()

            binding.etTitle.setText(currentTitle)
            binding.etContent.setText(currentContent)
        } else {
            Toast.makeText(this, "불러오기 실패", Toast.LENGTH_LONG).show()
        }

        binding.btnUpdate.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val content = binding.etContent.text.toString()

            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
                Toast.makeText(this, "데이터를 입력해주세요.", Toast.LENGTH_LONG).show()
            } else {
                val memo = Memo(currentId!!, title, content)
                memoViewModel.updateMemo(memo)
                finish()
            }
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }
}