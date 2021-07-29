package com.example.myrefrigerator.FRAGMENTS

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myrefrigerator.databinding.FragmentMusicBinding
import android.preference.PreferenceFragment
import android.util.Log
import android.widget.EditText
import com.example.myrefrigerator.R
import com.example.myrefrigerator.views.AllShelfLife
import com.example.myrefrigerator.views.MainActivity

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
        binding.settingSound.setOnClickListener(this)
        binding.settingNickName.setOnClickListener(this)
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
            binding.settingSound->{
                val builder = AlertDialog.Builder(activity)
                val dialogView = layoutInflater.inflate(R.layout.dialog_settingsound, null)
                builder.setView(dialogView)
                    //확인버튼 클릭 시, 이름와 유통기한을 AllShelfLife로 보냄
                    .setPositiveButton("확인") { dialogInterface, i ->

                    }
                    //취소 버튼
                    .setNegativeButton("취소") { dialogInterface, i ->
                        /* 취소일 때 아무 액션이 없으므로 빈칸 */
                    }
                    .show()
            }
            binding.settingNickName->{
                val builder = AlertDialog.Builder(activity)
                val dialogView = layoutInflater.inflate(R.layout.dialog_settingnickname, null)
                builder.setView(dialogView)
                    //확인버튼 클릭 시, 이름와 유통기한을 AllShelfLife로 보냄
                    .setPositiveButton("확인") { dialogInterface, i ->

                    }
                    //취소 버튼
                    .setNegativeButton("취소") { dialogInterface, i ->
                        /* 취소일 때 아무 액션이 없으므로 빈칸 */
                    }
                    .show()
            }
        }
    }
}