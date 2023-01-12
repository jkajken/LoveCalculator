package com.jk.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jk.lovecalculator.databinding.FragmentResultBinding
import com.jk.lovecalculator.remote.model.LoveModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getNameResults()
        tryAgain()
    }

    private fun tryAgain() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun getNameResults() {
        val data = arguments?.getSerializable("key") as LoveModel
        with(binding) {
            tvMe.text = data.firstName
            tvYou.text = data.secondName
            tvPercentage.text = buildString {
                append(data.percentage)
                append(("%"))
            }
            tvResult.text = data.result
        }
    }
}
