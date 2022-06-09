package com.lugares.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lugares.model.Empleado


@Database(entities=[Empleado::class], version = 1, exportSchema = false)
abstract class EmpleadoDataBase : RoomDatabase(){

    abstract fun empleadoDao() : EmpleadoDao
    companion object{
        @Volatile
        private var INSTANCE: EmpleadoDataBase? = null

        fun getDatabase(context: android.content.Context) : EmpleadoDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EmpleadoDataBase::class.java,
                    "Empleado_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}