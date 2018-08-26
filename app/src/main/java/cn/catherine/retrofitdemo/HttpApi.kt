package cn.catherine.retrofitdemo

import io.reactivex.Observable
import retrofit2.http.*

/**
 *
 * RetrofitDemo
 *
 * cn.catherine.retrofitdemo
 *
 * created by catherine in 八月/27/2018/上午1:12
 */
interface HttpApi {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("username") username: String, @Field("password") password: String): Observable<String>

    //, @Query("tag") tag: String, @Query("start") start: Int,
   // @Query("count") count: Int
    @FormUrlEncoded
    @GET("book/search")
    fun getSearchBook(@Query("q") name: String): Observable<String>

}