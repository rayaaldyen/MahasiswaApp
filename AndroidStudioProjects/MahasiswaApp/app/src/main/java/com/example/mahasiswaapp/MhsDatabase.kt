package com.example.mahasiswaapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MhsModel::class), version = 1, exportSchema = false)
abstract class MhsDatabase: RoomDatabase() {
    abstract fun getMhsDao(): MhsDao
    companion object {
        @Volatile
        private var INSTANCE: MhsDatabase? = null

        fun getDatabase(context: Context): MhsDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MhsDatabase::class.java,
                    "mhs_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}