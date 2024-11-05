package com.example.dd.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dd.view.PersonagemDB

@Database(entities = [PersonagemDB::class], version = 2, exportSchema = false)
abstract class DeD_DB : RoomDatabase() {
    abstract fun personagemDao(): PersonagemDAO

    companion object{

        @Volatile
        private var INSTANCE: DeD_DB? = null

        fun getDatabase(context: Context): DeD_DB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DeD_DB::class.java,
                    "deD_DB"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}