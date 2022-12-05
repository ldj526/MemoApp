package com.android.example.memoapp.repository

import androidx.lifecycle.LiveData
import com.android.example.memoapp.data.MemoDao
import com.android.example.memoapp.model.Memo

class MemoRepository(private val memoDao: MemoDao) {
    val readAllData: LiveData<List<Memo>> = memoDao.readAllData()

    suspend fun addMemo(memo: Memo) {
        memoDao.addMemo(memo)
    }

    suspend fun updateMemo(memo: Memo) {
        memoDao.updateMemo(memo)
    }

    suspend fun deleteMemo(memo: Memo) {
        memoDao.deleteMemo(memo)
    }
}