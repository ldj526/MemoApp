package com.android.example.memoapp

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.example.memoapp.databinding.ActivityMemoWriteBinding
import com.android.example.memoapp.model.Memo
import com.android.example.memoapp.viewmodel.MemoViewModel
import com.android.example.memoapp.viewmodel.MemoViewModelFactory

class MemoWriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemoWriteBinding
    private lateinit var memoViewModel: MemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_memo_write)
        memoViewModel =
            ViewModelProvider(this, MemoViewModelFactory(application))[MemoViewModel::class.java]

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val content = binding.etContent.text.toString()

            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
                Toast.makeText(applicationContext, "제목과 내용을 입력해주세요.", Toast.LENGTH_LONG).show()
            } else {
                val memo = Memo(0, title, content)
                memoViewModel.addMemo(memo)
                finish()
            }
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }
}