package com.android.example.memoapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.android.example.memoapp.database.Memo
import com.android.example.memoapp.database.MemoDatabase
import com.android.example.memoapp.database.MemoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoViewModel(application: Application) : AndroidViewModel(application) {
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