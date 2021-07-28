package com.example.myrefrigerator.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myrefrigerator.databinding.ActivityLoginBinding
import org.koin.standalone.StandAloneContext.startKoin
import com.example.myrefrigerator.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    // ViewModel
    private val myLoginViewModel = LoginViewModel()
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
        // setListener
        binding.login.setOnClickListener(this)
        binding.signup.setOnClickListener(this)
        // 옵저버, 로그인 결과를 계속 지켜본다.
        myLoginViewModel.resultLiveData.observe(this){
            if(it == true){
                // 로그인 성공했을 경우
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }
        // Log
        Log.e(SignupActivity.TAG, "LoginActivity - onCreate Call()")
    }

    override fun onClick(v: View?) {
        when(v){
            // 회원가입 창을 불렀을 경우
            binding.signup-> {
                val intent = Intent(this@LoginActivity, SignupActivity::class.java)
                startActivity(intent)
            }
                // Call 회원가입창
            binding.login-> {
                myLoginViewModel.Login(binding.id.text.toString(), binding.pass.text.toString())
            }
        }
    }
}