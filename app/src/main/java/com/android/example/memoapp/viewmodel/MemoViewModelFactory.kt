package com.android.example.memoapp.memowrite

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MemoWriteViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemoWriteViewModel::class.java)) {
            return MemoWriteViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}