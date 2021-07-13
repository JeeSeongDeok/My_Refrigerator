package com.example.myrefrigerator.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myrefrigerator.databinding.ActivityLoginBinding
import com.example.myrefrigerator.databinding.ActivitySignupBinding
import com.example.myrefrigerator.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    // ViewModel
    private val myLoginViewModel: LoginViewModel by viewModel()
    // Binding
    private var mBinding: ActivityLoginBinding? = null
    // mBinding이 null이 아닌 경우 get
    private val binding get() = mBinding!!
    companion object {
        const val TAG: String = "로그"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // XML 연결
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Log
        Log.e(SignupActivity.TAG, "LoginActivity - onCreate Call()")
    }

    override fun onClick(v: View?) {
        when(v){
            // 회원가입 창을 불렀을 경우
            binding.signup-> {
                val intent = Intent(this, SignupActivity)
                startActivity(intent)
            }
                // Call 회원가입창
            binding.login->
                myLoginViewModel.Login(binding.id.toString(), binding.pass.toString())
        }
    }
}