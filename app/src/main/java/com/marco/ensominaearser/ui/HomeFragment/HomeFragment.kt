package com.marco.ensominaearser.ui.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.marco.ensominaearser.R
import com.marco.ensominaearser.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setListeners()
        return binding.root
    }

    private fun setListeners(){
        binding.libraryBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_libraryFragment)
        }
        binding.cvMeditation.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_meditationFragment)
        }
        binding.cvMedicalConsultant.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_medicalConsultantFragment)
        }
    }


}