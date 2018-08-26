package cn.catherine.retrofitdemo

import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * RetrofitDemo
 *
 * cn.catherine.retrofitdemo
 *
 * created by catherine in 八月/27/2018/上午1:30
 */
fun <T> ioToMain(): FlowableTransformer<T, T> {
    return FlowableTransformer { upstream ->
        upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> newThreadToMain(): FlowableTransformer<T, T> {
    return FlowableTransformer { upstream ->
        upstream.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
