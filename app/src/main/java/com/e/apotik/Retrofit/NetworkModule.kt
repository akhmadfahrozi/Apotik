package com.e.apotik.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    //sesuaikan akses domain,ga boleh localhost(harus domain atau ip laptop)
    const val BASE_URL = "http://akhmad-fahrozi.com/ci-apotek/index.php/Obat/"
    //////////////////////////////////////////////////////////////////////////
    fun getOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }


    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttp())
            .build()
    }

    fun getService(): ApiServices {
        return getRetrofit().create<ApiServices>(ApiServices::class.java)
    }
}