package com.example.myrefrigerator.views


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myrefrigerator.databinding.ActivitySignupBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SignupActivity : AppCompatActivity(), View.OnClickListener {
    // Viewmodel
    private val mySignupViewModel: SignupViewModel by viewModel()
    // Binding
    private var mBinding: ActivitySignupBinding? = null
    // mBinding이 null이 아닌 경우 get
    private val binding get() = mBinding!!
    companion object {
        const val TAG: String = "로그"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // XML 연결
        mBinding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Log
        Log.e(TAG, "SignupActivity - onCreate Call()")
    }
    // 클릭 리스너
    override fun onClick(v: View?) {
        when(v){
            // Signup 버튼을 눌렀을 경우
            binding.signup->
                mySignupViewModel.sendSignUpInfo("쿼리문", 3)
        }
    }
}