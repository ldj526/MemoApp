package com.android.example.memoapp.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MemoDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao

    companion object {
        @Volatile
        private var INSTANCE: MemoDatabase? = null

        fun getDatabase(context: Context): MemoDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemoDatabase::class.java,
                        "memo_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}