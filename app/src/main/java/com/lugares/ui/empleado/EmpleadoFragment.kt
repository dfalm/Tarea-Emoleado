package com.lugares.ui.empleado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.lugares.R
import com.lugares.databinding.FragmentEmpleadoBinding
import com.lugares.ui.viewmodel.EmpleadoViewModel

class EmpleadoFragment : Fragment() {

    private lateinit var empleadoViewModel: EmpleadoViewModel
    private var _binding: FragmentEmpleadoBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        empleadoViewModel = ViewModelProvider(this)[EmpleadoViewModel::class.java]
        _binding = FragmentEmpleadoBinding.inflate(inflater,container,false)

        //Se programa la accion para pasarse a AddLugar
        binding.addEmpleadoButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_lugar_to_addLugarFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}