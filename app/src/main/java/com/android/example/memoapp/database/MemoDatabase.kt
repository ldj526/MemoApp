package com.android.example.memoapp.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MemoDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao

    companion object {
        @Volatile
        private var instance: MemoDatabase? = null

        fun getDatabase(context: Context): MemoDatabase? {
            if (instance == null) {
                synchronized(MemoDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemoDatabase::class.java,
                        "memo_database"
                    ).build()
                }
            }
            return instance
        }
    }
}