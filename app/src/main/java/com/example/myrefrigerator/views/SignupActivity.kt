package com.example.myrefrigerator.views


import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.myrefrigerator.R
import com.example.myrefrigerator.databinding.ActivitySignupBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.util.*


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
    //달력선택
    var today = GregorianCalendar()
    var year: Int = today.get(Calendar.YEAR)
    var month: Int = today.get(Calendar.MONTH)
    var date: Int = today.get(Calendar.DATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // XML 연결
        mBinding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Log
        Log.e(TAG, "SignupActivity - onCreate Call()")
        // setListener
        binding.overlap.setOnClickListener(this)
        binding.birthBtn.setOnClickListener(this)
        binding.signup.setOnClickListener(this)
    }

    fun blank_edit() {
        if (binding.id.length() == 0)
            Toast.makeText(this@SignupActivity, "아이디를 채워주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.pass.length() == 0)
            Toast.makeText(this@SignupActivity, "비밀번호를 채워주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.repass.length() == 0)
            Toast.makeText(this@SignupActivity, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.username.length() == 0)
            Toast.makeText(this@SignupActivity, "이름을 채워주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.phonenumber.length() == 0)
            Toast.makeText(this@SignupActivity, "전화번호를 채워주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.birth.length() == 0)
            Toast.makeText(this@SignupActivity, "생년월일을 채워주세요.", Toast.LENGTH_SHORT).show()
        //둘 중 하나만
        else if (binding.radioMan.isChecked == false && binding.radioWoman.isChecked == false)
            Toast.makeText(this@SignupActivity, "성별칸을 채워주세요.", Toast.LENGTH_SHORT).show()
        //세개 다 채워야
        else if (binding.agree1.isChecked == false || binding.agree2.isChecked == false ||
            binding.agree3.isChecked == false)
            Toast.makeText(this@SignupActivity, "이용약관에 동의해주세요.", Toast.LENGTH_SHORT).show()
        //모든 칸이 채워졌을 때
        else {
            mySignupViewModel.sendSignUpInfo("쿼리문", 3)
        }
    }
    // API 연결, SignupModel로 옮겨갈 예정
    fun test() {

    }

    // 클릭 리스너1
    override fun onClick(v: View?) {
        when (v) {
            // Signup 버튼을 눌렀을 경우
            binding.signup -> {
                Log.d(SignupActivity.TAG, "LoginActivity - onCreate Call()")
                blank_edit()
            }
            //중복확인
            binding.overlap->{
                Toast.makeText(this@SignupActivity, "중복확인", Toast.LENGTH_SHORT).show()
            }
            //달력선택
            binding.birthBtn -> {
                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                        binding.birth.setText("${year}년 ${month+1}월 ${dayOfMonth}일")
                    }
                }, year, month, date)
                dlg.show()
            }
        }
    }
}

