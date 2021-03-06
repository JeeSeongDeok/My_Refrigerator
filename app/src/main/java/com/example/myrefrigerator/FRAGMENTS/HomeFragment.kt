package com.example.myrefrigerator.FRAGMENTS

import android.animation.ValueAnimator
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.airbnb.lottie.*
import com.example.myrefrigerator.R
import com.example.myrefrigerator.databinding.FragmentHomeBinding
import com.example.myrefrigerator.viewmodel.HomeFragmentViewModel
import com.example.myrefrigerator.views.AllShelfLife
import com.example.myrefrigerator.views.SignupActivity


class HomeFragment : Fragment(), View.OnClickListener {
    private var mBinding: FragmentHomeBinding? = null
    lateinit var binding: FragmentHomeBinding

    private var viewModel = HomeFragmentViewModel()

    //서버에서 가져온 음식 유통기한을 담을 변수
    //현재 숫자들은 test용, 나중에 0으로 초기화 해서 사용
    //Lottie안에 넣을 때는 *10을 해서 넣으면 10일 이하 음식들이기 때문에 사이즈가 맞다
    private var firstFood:Int = 8
    private var secondFood:Int = 8
    private var thirdFood:Int = 9
    private var forthFood:Int = 10

    //서버에서 가져올 음식이름 담을 변수, ""안의 숫자는 테스트용 나중에 ""로 초기화 해서 사용
    private var firstFoodName:String = "우유"
    private var secondFoodName:String = "계란"
    private var thirdFoodName:String = "배추"
    private var forthFoodName:String = "새우"

    val TAG: String = "로그"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        mBinding = binding



        //Lottie 함수, 최대 크기 100, 서버에서 10일 이하로 남은 음식에 *10해서 lottie에 설정
        //첫번째 음식
        LottieAnimationView1()
        //두번째 음식
        LottieAnimationView2()
        //세번째 음식
        LottieAnimationView3()
        //네번째 음식
        LottieAnimationView4()

        //setOnClickListener설정
        binding.watchShelfLife.setOnClickListener(this)
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    fun LottieAnimationView1(){
        //서버에서 가져온 음식 이름, 음식이름 실제로 가져왓을 때는 앞의 "음식이름"을 지우고 사용
        //"${editText.text}님 반갑습니다."
        binding.foodName1.setText(firstFoodName)
        binding.foodLeft1.setText("${firstFood}일 남음")
        //Lottie 라인을 전체 100중 firstFood * 10인 50만큼만 채운다
        binding.animationView1.setMaxFrame(firstFood*10)
        //LottieAnimation 실행
        binding.animationView1.playAnimation()
    }

    fun LottieAnimationView2(){
        binding.foodName2.setText(secondFoodName)
        binding.foodLeft2.setText("${secondFood}일 남음")
        binding.animationView2.setMaxFrame(secondFood*10)
        binding.animationView2.playAnimation()
    }

    fun LottieAnimationView3(){
        binding.foodName3.setText(thirdFoodName)
        binding.foodLeft3.setText("${thirdFood}일 남음")
        binding.animationView3.setMaxFrame(thirdFood*10)
        binding.animationView3.playAnimation()

    }

    fun LottieAnimationView4(){
        binding.foodName4.setText(forthFoodName)
        binding.foodLeft4.setText("${forthFood}일 남음")
        binding.animationView4.setMaxFrame(forthFood*10)
        binding.animationView4.playAnimation()
    }


    //setOnClickListener
    override fun onClick(v: View?) {
        when (v) {
            //WatchShelfLife 버튼 누르면 4개 외의 모든 유통기한을 모아놓은 activity로 이동
            binding.watchShelfLife -> {
                val intent = Intent(activity, AllShelfLife::class.java)
                startActivity(intent)
            }
        }
    }
}

