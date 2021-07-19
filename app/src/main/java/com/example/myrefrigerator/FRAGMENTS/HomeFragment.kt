package com.example.myrefrigerator.FRAGMENTS

import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.LottieDrawable
import com.airbnb.lottie.OnCompositionLoadedListener
import com.example.myrefrigerator.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var mBinding: FragmentHomeBinding? = null
    val TAG: String = "로그"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        mBinding = binding

        //Lottie 설정정, 최대 크기 100이므로 /10으로 10일 이하로 남은 음식을 알려준다.
        val drawable1 = LottieDrawable()
        val drawable2 = LottieDrawable()
        val drawable3 = LottieDrawable()
        val drawable4 = LottieDrawable()

        //
        LottieComposition.Factory.fromAssetFileName(
            activity,
            "line.json",
            OnCompositionLoadedListener { composition: LottieComposition? ->
                drawable1.composition = composition
                drawable1.playAnimation()
                drawable1.setMaxFrame(50)
                binding.animationView1.setImageDrawable(drawable1)
            }
        )

        LottieComposition.Factory.fromAssetFileName(
            activity,
            "line.json",
            OnCompositionLoadedListener { composition: LottieComposition? ->
                drawable2.composition = composition
                drawable2.playAnimation()
                drawable2.setMaxFrame(70)
                binding.animationView2.setImageDrawable(drawable2)
            }
        )

        LottieComposition.Factory.fromAssetFileName(
            activity,
            "line.json",
            OnCompositionLoadedListener { composition: LottieComposition? ->
                drawable3.composition = composition
                drawable3.playAnimation()
                drawable3.setMaxFrame(100)
                binding.animationView3.setImageDrawable(drawable3)
            }
        )

        LottieComposition.Factory.fromAssetFileName(
            activity,
            "line.json",
            OnCompositionLoadedListener { composition: LottieComposition? ->
                drawable4.composition = composition
                drawable4.playAnimation()
                drawable4.setMaxFrame(60)
                binding.animationView4.setImageDrawable(drawable4)
            }
        )

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}