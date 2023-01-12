package com.jk.lovecalculator.onboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.jk.lovecalculator.R
import com.jk.lovecalculator.databinding.ItemOnBoardingBinding
import com.jk.lovecalculator.remote.model.OnBoard

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val arrayList = arrayListOf<OnBoard>(
        OnBoard(R.raw.sendheart, "Task Manager", "Creative space to save your time"),
        OnBoard(R.raw.socil, "Notifications", "Quick notes on the go"),
        OnBoard(R.raw.vitrual, "Notifications", "Quick notes on the go"),
        OnBoard(R.raw.romatictext, "Always with you", "Fully functional offline")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {

            binding.apply {

                btnGetStarted.isVisible = adapterPosition == arrayList.lastIndex
                onBoard.image?.let { onBoardLottie.setAnimation(it) }
                tvTitle.text = onBoard.title
                tvDescription.text = onBoard.description
                binding.btnGetStarted.setOnClickListener {
                    onClick()
                }

            }

        }

    }

}