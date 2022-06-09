package com.lugares.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lugares.model.Empleado


@Dao
interface EmpleadoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEmpleado(empleado: Empleado)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateEmpleado(empleado: Empleado)

    @Delete
    suspend fun deleteEmpleado(empleado: Empleado)

    @Query("SELECT * FROM Empleado")
    fun getAllData() : LiveData<List<Empleado>>
}