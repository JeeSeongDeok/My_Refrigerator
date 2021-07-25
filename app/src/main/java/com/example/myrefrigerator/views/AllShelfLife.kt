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
import com.example.myrefrigerator.databinding.ActivityAllshelflifeBinding
import com.example.myrefrigerator.databinding.ActivitySignupBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.util.*

class AllShelfLife : AppCompatActivity() {
    // Binding
    private var mBinding: ActivityAllshelflifeBinding? = null
    // mBinding이 null이 아닌 경우 get
    private val binding get() = mBinding!!
    companion object {
        const val TAG: String = "로그"
    }
    private val TAG: String = "AllShelfLife"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // XML 연결
        mBinding = ActivityAllshelflifeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // MainActivity에서 가져온 데이터
        if (intent.hasExtra("name") && intent.hasExtra("shelfLife")) {
            val name = intent.getStringExtra("name")
            val shelfLife = intent.getStringExtra("shelfLife")
            binding.foodName.setText("이것은${name}")
            binding.foodshelflife.setText("이것은${shelfLife}")
        }else{
            Log.e(TAG, "가져온 데이터 없음")
        }
    }
}