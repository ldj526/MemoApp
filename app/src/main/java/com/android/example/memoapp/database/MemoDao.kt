package com.android.example.memoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMemo(memo: Memo)

    @Query("SELECT * FROM memo_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Memo>>
}