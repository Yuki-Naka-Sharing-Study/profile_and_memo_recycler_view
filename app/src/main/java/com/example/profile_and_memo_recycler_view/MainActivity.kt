package com.example.profile_and_memo_recycler_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profile_and_memo_recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mList: ArrayList<DataItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        mList = ArrayList()
        prepareData()

        val adapter = MainAdapter(mList)
        binding.recyclerView.adapter = adapter
    }

    private fun prepareData() {

        mList.add(
            DataItem(
                "名前",
                "田中太郎",
                null,
                null
            )
        )

        mList.add(
            DataItem(
                "フリガナ",
                "タナカタロウ",
                null,
                null
            )
        )

        mList.add(
            DataItem(
                "ニックネーム",
                "たろちゃん",
                null,
                null
            )
        )

        mList.add(
            DataItem(
                "性別",
                "未選択",
                null,
                null
            )
        )

        mList.add(
            DataItem(
                "誕生日",
                "2000年1月1日",
                null,
                null
            )
        )

        mList.add(
            DataItem(
                "出身地",
                "秋田県",
                null,
                null
            )
        )

        mList.add(
            DataItem(
                "住所",
                "東京都",
                null,
                R.drawable.folder
            )
        )

        mList.add(
            DataItem(
                "職業",
                "エンジニア",
                null,
                null
            )
        )

        mList.add(
            DataItem(
                "関係",
                "会社の同僚",
                null,
                null
            )
        )

        mList.add(
            DataItem(
                "電話番号",
                "080-1234-1234",
                null,
                R.drawable.link
            )
        )

        mList.add(
            DataItem(
                "Email",
                "taro@example.com",
                null,
                R.drawable.link
            )
        )

        mList.add(
            DataItem(
                "X(旧Twitter)",
                "@tanakataro",
                null,
                R.drawable.link
            )
        )

        mList.add(
            DataItem(
                "Instagram",
                "@tanakataro",
                null,
                R.drawable.link
            )
        )

        mList.add(
            DataItem(
                "Facebook",
                "@tanakataro",
                null,
                R.drawable.link
            )
        )

        mList.add(
            DataItem(
                null,
                "内容",
                "カスタム1",
                null
            )
        )

        mList.add(
            DataItem(
                null,
                "内容",
                "カスタム2",
                null
            )
        )

        mList.add(
            DataItem(
                null,
                "内容",
                "カスタム3",
                null,
            )
        )
    }
}