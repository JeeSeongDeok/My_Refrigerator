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

        // MainActivity에서 가져온 데이터
        if (intent.hasExtra("name") && intent.hasExtra("shelfLife")) {
            val name = intent.getStringExtra("name")
            val shelfLife = intent.getStringExtra("shelfLife")
            binding.foodName.setText("이것은${name}")
            binding.foodshelflife.setText("이것은${shelfLife}")
            //리사이클뷰
            var mlist = ArrayList<AllShelfLifeListView>()
            mlist.add(AllShelfLifeListView(getDrawable(R.mipmap.ic_launcher),name+"", shelfLife+""))
            //리사이클뷰 어댑터
            val Adapter = AllShelfLifeAdapter(this, mlist)
            binding.RecyclerView.adapter = Adapter
        } else {
            Log.e(TAG, "가져온 데이터 없음")
        }
    }
}