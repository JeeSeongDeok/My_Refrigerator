package com.example.myrefrigerator.views


import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myrefrigerator.R
import com.example.myrefrigerator.databinding.ActivitySignupBinding
import org.koin.androidx.viewmodel.ext.android.ViewModelStoreOwnerDefinition
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class SignupActivity : AppCompatActivity(), View.OnClickListener {
    // Viewmodel
    private val mySignupViewModel = SignupViewModel()
    // Binding
    private lateinit var binding: ActivitySignupBinding
    //private val binding get() = mBinding!!
    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // XML 연결
        binding = DataBindingUtil.setContentView<ActivitySignupBinding>(this, R.layout.activity_signup)
        binding.su = SignupActivity()
        // Log
        Log.e(TAG, "SignupActivity - onCreate Call()")
    }

    fun blank_edit() {
        if (binding.id.toString().equals(""))
            Log.d(SignupActivity.TAG, "id채워지지 않음")
        else if (binding.pass.toString().equals(""))
            Toast.makeText(this@SignupActivity, "비밀번호를 채워주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.repass.toString().equals(""))
            Toast.makeText(this@SignupActivity, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.username.toString().equals(""))
            Toast.makeText(this@SignupActivity, "이름을 채워주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.phonenumber.toString().equals(""))
            Toast.makeText(this@SignupActivity, "전화번호를 채워주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.birth.toString().equals(""))
            Toast.makeText(this@SignupActivity, "생년월일을 채워주세요.", Toast.LENGTH_SHORT).show()
        else if (binding.radioMan.isChecked == false || binding.radioWoman.isChecked == false)
            Toast.makeText(this@SignupActivity, "성별칸을 채워주세요.", Toast.LENGTH_SHORT).show()
        //대 채워졌을 때
        else {
            mySignupViewModel.sendSignUpInfo("쿼리문", 3)
        }
    }

    // 클릭 리스너
    override fun onClick(v: View?) {
        when (v) {
            // Signup 버튼을 눌렀을 경우
            binding.signup -> {
                Log.d(SignupActivity.TAG, "LoginActivity - onCreate Call()")
                blank_edit()
            }
            //생년월일 선택
            binding.birthBtn -> {
                var today = GregorianCalendar()
                var year: Int = today.get(Calendar.YEAR)
                var month: Int = today.get(Calendar.MONTH)
                var date: Int = today.get(Calendar.DATE)

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