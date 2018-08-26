package cn.catherine.retrofitdemo

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * RetrofitDemo
 *
 * cn.catherine.retrofitdemo
 *
 * created by catherine in 八月/27/2018/上午12:24
 */
class TestActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.text = "test"

    }
}