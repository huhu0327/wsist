package com.huhu.wsist.`interface`

import com.huhu.wsist.model.Music
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("karaoke/kumyoung.json")
    fun getRecentMusicInfoFromKY(): Call<List<Music>>

    @GET("karaoke/singer/{singer}/kumyoung.json")
    fun getMusicInfoFromKYUsingSinger(@Path("singer") singerName: String): Call<List<Music>>

    @GET("karaoke/song/{song}/kumyoung.json")
    fun getMusicInfoFromKYUsingTitle(@Path("song") titleName: String): Call<List<Music>>

    @GET("karaoke/tj.json")
    fun getRecentMusicInfoFromTJ(): Call<List<Music>>

    @GET("karaoke/singer/{singer}/tj.json")
    fun getMusicInfoFromTJUsingSinger(@Path("singer") singerName: String): Call<List<Music>>

    @GET("karaoke/song/{song}/tj.json")
    fun getMusicInfoFromTJUsingTitle(@Path("song") titleName: String): Call<List<Music>>

    //https://api.manana.kr/karaoke/singer/fripside/kumyoung.json
}