package com.android.example.memoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.example.memoapp.model.Memo

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMemo(memo: Memo)

    @Update
    suspend fun updateMemo(memo: Memo)

    @Query("SELECT * FROM memo_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Memo>>
}