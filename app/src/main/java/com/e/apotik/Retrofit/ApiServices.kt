package com.e.apotik.Retrofit

import com.e.apotik.Model.ResponseOutlet
import com.e.apotik.Obatt.ResponseObat
import com.e.apotik.transaksi.ResponseTransaksi
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServices {
//GET berfungsi nampilkan data
    @GET("outlet_json")
    fun outlet(): Call<ResponseOutlet>

    @GET("transaksi_json")
    fun transaksi(): Call<ResponseTransaksi>

    @GET("obat_json")
    fun obat(): Call<ResponseObat>

    @GET("cari_outlet_json")//bisa disamakan di respon outlet
    fun cari(@Query("name")name:String): Call<ResponseOutlet>

    @GET("cari_obat_json")
    fun cari_obat(@Query("name")name: String): Call<ResponseObat>

}