package com.lugares.repository

import androidx.lifecycle.LiveData
import com.lugares.data.LugarDao
import com.lugares.model.Lugar

class LugarRepository(private val lugarDao: LugarDao) {
    //Se crea un objeto que contiene el array listo de los registros de la tabla lugar.... cubiertos por
    val getAllData: LiveData<List<Lugar>> = lugarDao.getAllData()

    //se define la funcion para insertar un lugar en la tabla lugar
    suspend fun addLugar(lugar:Lugar) {
        lugarDao.addLugar(lugar)
    }

    //se define la funcion para actualizar un lugar en la tabla lugar
    suspend fun updateLugar(lugar:Lugar) {
        lugarDao.updateLugar(lugar)
    }

    //se define la funcion para eliminar un lugar en la tabla lugar
    suspend fun deleteLugar(lugar:Lugar) {
        lugarDao.deleteLugar(lugar)
    }
}