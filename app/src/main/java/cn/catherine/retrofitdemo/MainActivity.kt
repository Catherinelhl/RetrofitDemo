package cn.catherine.retrofitdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.BindView
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * this is an example of learning how to use retrofit correctly.
 *
 * @author catherine liu
 *
 * 步骤1：添加Retrofit库的依赖
 * 步骤2：创建 接收服务器返回数据 的类
 * 步骤3：创建 用于描述网络请求 的接口
 * 步骤4：创建 Retrofit 实例
 * 步骤5：创建 网络请求接口实例 并 配置网络请求参数
 * 步骤6：发送网络请求（异步 / 同步）
 * 步骤7：处理服务器返回的数据
 * step 1:
 *  import the library of retrofit
 *  add the permission of internet
 * step 2: create a class 「that」to accept the data of server
 * step 3: create a interface to description the http request
 *
 *
 */

class MainActivity : AppCompatActivity() {


    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RxView.clicks(tv)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe({
                    println("onNext")
                },
                        {
                            println("onError")
                        },
                        {
                            println("onComplete")
                        },
                        {
                            println("onSubscriber")
                        })


    }

    /*重试*/
    private fun retryWhen() {
        //https://api.douban.com/v2/
        val retrofit = Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        val request = retrofit.create(HttpApi::class.java)
        val observable = request.getSearchBook("catherine")
//        val observableRetryWhen = observable.retryWhen({
//                return it.flatMap { if (it is IOException){} }
//        })
//
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ println("onNext$it") },
//                        { println("onError$it") },
//                        { println("onComplete") },
//                        { println("onSubscribe$it") })
//        compositeDisposable.add(observableRetryWhen)

    }

    /*轮询*/
    private fun repeatWhen() {}

    /*取消订阅*/
    private fun unSubscribe() {
        compositeDisposable.clear()
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}
