package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.view.adapter.MainAdapter

import com.example.view.model.Member

class MainActivity : AppCompatActivity() {


    lateinit var first:LinearLayout
    lateinit var second:LinearLayout
    lateinit var third:LinearLayout
    lateinit var recyclerView:RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val members  = prepareMemberList()

        refreshAdapter(members)
    }



    private fun initViews() {
        recyclerView = findViewById<RecyclerView>(R.id.rv_main)
        first = findViewById(R.id.ll_first)
        second = findViewById(R.id.ll_second)
        third = findViewById(R.id.ll_third)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        recyclerView.setOnScrollListener(object : RecyclerView.OnScrollListener(){

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val layoutManager = recyclerView!!.layoutManager as LinearLayoutManager
                val activePosition = layoutManager.findFirstCompletelyVisibleItemPosition()
                if (activePosition == RecyclerView.NO_POSITION) return
                when(activePosition){
                    0 -> {
                        first.apply {
                            setBackgroundResource(R.drawable.ll_rounded_active)
                            layoutParams.width = 14
                            layoutParams.height = 14
                        }
                        second.apply {
                            setBackgroundResource(R.drawable.ll_rounded)
                            layoutParams.width = 10
                            layoutParams.height = 10
                        }
                        third.apply {
                            setBackgroundResource(R.drawable.ll_rounded)
                            layoutParams.width = 10
                            layoutParams.height = 10
                        }
                    }
                    1 -> {
                        first.apply {
                            setBackgroundResource(R.drawable.ll_rounded)
                            layoutParams.width = 10
                            layoutParams.height = 10
                        }
                        second.apply {
                            setBackgroundResource(R.drawable.ll_rounded_active)
                            layoutParams.width = 14
                            layoutParams.height = 14
                        }
                        third.apply {
                            setBackgroundResource(R.drawable.ll_rounded)
                            layoutParams.width = 10
                            layoutParams.height = 10
                        }
                    }
                    else -> {
                        first.apply {
                            setBackgroundResource(R.drawable.ll_rounded)
                            layoutParams.width = 10
                            layoutParams.height = 10
                        }
                        second.apply {
                            setBackgroundResource(R.drawable.ll_rounded)
                            layoutParams.width = 10
                            layoutParams.height = 10
                        }
                        third.apply {
                            setBackgroundResource(R.drawable.ll_rounded_active)
                            layoutParams.width = 14
                            layoutParams.height = 14
                        }
                    }
                }
            }
        })
    }
    private fun refreshAdapter(mems: List<Member>) {
        val adapter  = MainAdapter(mems)
        recyclerView.adapter = adapter

    }

    private fun prepareMemberList(): List<Member> {
        val mems = ArrayList<Member>()


        mems.add(Member("a","a"))
        mems.add(Member("a","a"))
        mems.add(Member("a","a"))
        return mems


    }



}