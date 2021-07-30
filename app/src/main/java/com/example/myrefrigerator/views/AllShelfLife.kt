package com.example.myrefrigerator.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myrefrigerator.Adapter.AllShelfLifeAdapter
import com.example.myrefrigerator.data.AllShelfLifeListView
import com.example.myrefrigerator.databinding.ActivityAllshelflifeBinding
import java.util.*
import androidx.recyclerview.widget.LinearLayoutManager
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myrefrigerator.R

class AllShelfLife : AppCompatActivity() {
    // Binding
    private var mBinding: ActivityAllshelflifeBinding? = null

    // mBinding이 null이 아닌 경우 get
    private val binding get() = mBinding!!

    companion object {
        const val TAG: String = "로그"
    }

    private val TAG: String = "AllShelfLife"

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // XML 연결
        mBinding = ActivityAllshelflifeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mlist = ArrayList<AllShelfLifeListView>()
        // MainActivity에서 가져온 데이터

        val name = intent.getStringExtra("name")
        val shelfLife = intent.getStringExtra("shelfLife")
        //리사이클뷰
        mlist.add(AllShelfLifeListView("요플레", "13일 남음"))
        mlist.add(AllShelfLifeListView("복숭아", "20일 남음"))
        mlist.add(AllShelfLifeListView("어묵", "15일 남음"))
        mlist.add(AllShelfLifeListView("치킨소스", "89일 남음"))
//        mlist.add(
//            AllShelfLifeListView(
//                getDrawable(R.mipmap.ic_launcher),
//                name + "",
//                shelfLife + ""
//            )
//        )
        //리사이클뷰 어댑터
        val Adapter = AllShelfLifeAdapter(this, mlist)
        binding.RecyclerView.adapter = Adapter


    }
}