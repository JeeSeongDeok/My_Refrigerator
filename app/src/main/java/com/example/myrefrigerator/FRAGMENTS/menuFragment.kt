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

class menuFragment : Fragment(), View.OnClickListener {
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

        //setOnClickListener
        binding.addFood.setOnClickListener(this)

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    override fun onClick(v: View?) {
        when (v) {
            //음식 추가하는 dialog call
            binding.addFood -> {
                val builder = AlertDialog.Builder(activity)
                val dialogView = layoutInflater.inflate(R.layout.dialog_addfood, null)
                builder.setView(dialogView)
                    .setPositiveButton("확인") { dialogInterface, i ->
                        Log.d(TAG, "HomeFragment - Positive Call()")
                    }
                    .setNegativeButton("취소") { dialogInterface, i ->
                        /* 취소일 때 아무 액션이 없으므로 빈칸 */
                    }
                    .show()
            }
        }
    }
}