package com.example.myrefrigerator.FRAGMENTS

import android.os.Bundle
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myrefrigerator.databinding.FragmentMusicBinding

class musicFragment : Fragment(), View.OnClickListener {
    private var mBinding : FragmentMusicBinding? = null
    lateinit var binding: FragmentMusicBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        mBinding = binding

        //리스너 등록
        binding.vibrateSwitch.setOnClickListener(this)
        binding.soundSwitch.setOnClickListener(this)
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    override fun onClick(v: View?) {
        when(v){
            binding.vibrateSwitch->{
                if(binding.vibrateSwitch.isChecked){

                }
                else{

                }
            }
            binding.soundSwitch->{
                if(binding.soundSwitch.isChecked){

                }
                else{

                }
            }
        }
    }
}