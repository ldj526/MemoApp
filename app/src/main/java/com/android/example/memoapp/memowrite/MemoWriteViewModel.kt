package com.android.example.memoapp.memowrite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.android.example.memoapp.database.Memo
import com.android.example.memoapp.database.MemoDatabase
import com.android.example.memoapp.database.MemoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoWriteViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<Memo>>
    private val repository: MemoRepository

    init {
        val memoDao = MemoDatabase.getDatabase(application).memoDao()
        repository = MemoRepository(memoDao)
        readAllData = repository.readAllData
    }

    fun addMemo(memo: Memo){
        viewModelScope.launch(Dispatchers.IO){
            repository.addMemo(memo)
        }
    }
}