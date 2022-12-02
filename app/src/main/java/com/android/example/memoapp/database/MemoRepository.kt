package com.android.example.memoapp.database

import androidx.lifecycle.LiveData

class MemoRepository(private val memoDao: MemoDao) {
    val readAllData: LiveData<List<Memo>> = memoDao.readAllData()

    suspend fun addMemo(memo: Memo) {
        memoDao.addMemo(memo)
    }
}