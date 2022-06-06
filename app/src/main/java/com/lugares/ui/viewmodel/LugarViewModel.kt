package com.lugares.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.lugares.data.LugarDataBase
import com.lugares.model.Lugar
import com.lugares.repository.LugarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LugarViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Lugar>>

    //Esta es la manera para acceder al repositorio desde el viewmodel
    private val repository: LugarRepository

    //Se inicializan los atributos de la clase viewModel
    init{
        val lugarDao = LugarDataBase.getDatabase(application).lugarDao()
        repository = LugarRepository(lugarDao)
        getAllData = repository.getAllData
    }

    //Esta funcion de alto nivel llama al subproceso de I/O para grabar un registro Lugar
    fun addLugar(lugar : Lugar){

        viewModelScope.launch(Dispatchers.IO){

            repository.addLugar(lugar)
        }

    }

    //Esta funcion de alto nivel llama al subproceso de I/O para actualizar un registro Lugar
    fun updateLugar(lugar : Lugar){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateLugar(lugar)
        }
    }

    //Esta funcion de alto nivel llama al subproceso de I/O para eliminar un registro Lugar
    fun deleteLugar(lugar : Lugar){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteLugar(lugar)
        }
    }

}