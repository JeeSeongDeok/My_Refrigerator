package com.example.myrefrigerator.views


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myrefrigerator.databinding.ActivitySignupBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SignupActivity : AppCompatActivity(), View.OnClickListener {
    // Viewmodel
    private val mySignupViewModel = SignupViewModel()
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
        // setListener
        binding.signup.setOnClickListener(this)
    }
    fun blank_edit(){
        if(binding.id.length() == 0)
            Toast.makeText(this@SignupActivity, "아이디를 채워주세요.", Toast.LENGTH_SHORT).show()
        else if(binding.pass.length() == 0)
            Toast.makeText(this@SignupActivity, "비밀번호를 채워주세요.", Toast.LENGTH_SHORT).show()
        else if(binding.repass.length() == 0)
            Toast.makeText(this@SignupActivity, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
        else if(binding.username.length() == 0)
            Toast.makeText(this@SignupActivity, "이름을 채워주세요.", Toast.LENGTH_SHORT).show()
        else if(binding.phonenumber.length() == 0)
            Toast.makeText(this@SignupActivity, "전화번호를 채워주세요.", Toast.LENGTH_SHORT).show()
        else if(binding.birth.length() == 0)
            Toast.makeText(this@SignupActivity, "생년월일을 채워주세요.", Toast.LENGTH_SHORT).show()
        else if(binding.radioMan.isChecked == false || binding.radioWoman.isChecked == false)
            Toast.makeText(this@SignupActivity, "성별칸을 채워주세요.", Toast.LENGTH_SHORT).show()
    }
    // 클릭 리스너
    override fun onClick(v: View?) {
        when(v){
            // Signup 버튼을 눌렀을 경우
            binding.signup-> {
                blank_edit()
                mySignupViewModel.sendSignUpInfo("쿼리문", 3)
            }
        }
    }
}