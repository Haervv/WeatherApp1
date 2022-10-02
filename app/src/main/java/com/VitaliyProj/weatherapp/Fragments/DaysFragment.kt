package com.VitaliyProj.weatherapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.VitaliyProj.weatherapp.MainViewModel
import com.VitaliyProj.weatherapp.R
import com.VitaliyProj.weatherapp.adapters.WeatherAdapter
import com.VitaliyProj.weatherapp.databinding.FragmentDaysBinding


class DaysFragment : Fragment() {
    private lateinit var adapter: WeatherAdapter
    private lateinit var binding: FragmentDaysBinding
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDaysBinding.inflate(inflater,  container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.liveDataList.observe(viewLifecycleOwner){
            adapter.submitList(it.subList(1, it.size))
        }
    }

    private fun init() = with(binding) {
        adapter = WeatherAdapter()
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            DaysFragment()
    }
}