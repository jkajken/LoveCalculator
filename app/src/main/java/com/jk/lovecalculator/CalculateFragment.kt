package com.jk.lovecalculator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.jk.lovecalculator.databinding.FragmentCalculateBinding
import com.jk.lovecalculator.main.LoveViewModel
import com.jk.lovecalculator.onboard.Prefs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalculateFragment : Fragment() {

    private lateinit var binding: FragmentCalculateBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var pref: Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref.onPref(requireContext())
        if (pref.isOnBoardingShow()) {
            findNavController().navigate(R.id.onBoardingFragment)
        }
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveModel(
                    firstName = etName1.text.toString(),
                    secondName = etName2.text.toString()
                ).observe(viewLifecycleOwner,
                    Observer {
                        viewLifecycleOwner
                        val data = it
                        findNavController().navigate(
                            R.id.resultFragment, bundleOf("key" to data)
                        )
                    })
            }

        }
    }
}