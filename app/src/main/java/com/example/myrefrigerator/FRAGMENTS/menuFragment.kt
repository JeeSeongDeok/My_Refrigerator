package com.example.myrefrigerator.FRAGMENTS

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myrefrigerator.R
import com.example.myrefrigerator.databinding.FragmentMenuBinding

//따로 dialog띄워서 필요없는 소스 지웠습니다.
class menuFragment : Fragment() {
    private var mBinding: FragmentMenuBinding? = null
    lateinit var binding: FragmentMenuBinding
    val TAG: String = "로그"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        mBinding = binding

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}