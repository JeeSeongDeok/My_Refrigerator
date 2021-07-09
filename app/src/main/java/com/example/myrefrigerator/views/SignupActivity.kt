package com.example.myrefrigerator.views

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myrefrigerator.R
import com.example.myrefrigerator.base.BaseView
import com.example.myrefrigerator.databinding.ActivitySignupBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignupActivity : BaseView<ActivitySignupBinding, SignupViewModel>() {
    private lateinit var id:EditText
    private lateinit var pass:EditText
    private lateinit var repass:EditText
    private lateinit var username:EditText
    private lateinit var phoneNumber:EditText
    private lateinit var birth:EditText
    private lateinit var manRadiobtn:RadioButton
    private lateinit var womenRadiobtn:RadioButton
    private lateinit var agreeBtn:RadioButton                                                       // 이용약관동의
    private lateinit var agreeBtn2:RadioButton                                                      // 개인정보취급방침동의
    private lateinit var agreeBtn3:RadioButton                                                      // 마케팅정보 수신 동의
    private lateinit var genderGroup:RadioGroup
    private lateinit var overlapBtn:Button
    override val layoutResourceId: Int
        get() = R.layout.activity_signup

    override val viewModel: SignupViewModel = SignupViewModel()                                     // 이 부분??

    override fun initStartView() {
        initUI()
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {
        setListener()
    }

    fun initUI(){
        id = findViewById<EditText>(R.id.id)
        pass = findViewById<EditText>(R.id.pass)
        repass = findViewById<EditText>(R.id.repass)
        username = findViewById<EditText>(R.id.username)
        phoneNumber = findViewById<EditText>(R.id.phonenumber)
        birth = findViewById<EditText>(R.id.birth)
        manRadiobtn = findViewById<RadioButton>(R.id.radio_man)
        womenRadiobtn = findViewById<RadioButton>(R.id.radio_woman)
        agreeBtn = findViewById<RadioButton>(R.id.agree1)
        agreeBtn2 = findViewById<RadioButton>(R.id.agree2)
        agreeBtn3 = findViewById<RadioButton>(R.id.agree3)
        genderGroup = findViewById<RadioGroup>(R.id.genderGroup)
        overlapBtn = findViewById<Button>(R.id.overlap)
    }
    fun setListener(){
        overlapBtn.setOnClickListener {
            // 아이디 중복
            viewModel.sendSignUpInfo("쿼리", 35)
        };
    }
}