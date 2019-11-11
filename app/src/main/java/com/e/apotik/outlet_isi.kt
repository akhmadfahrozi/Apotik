package com.e.apotik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.apotik.Model.DataItem
import com.e.apotik.Model.ResponseOutlet
import com.e.apotik.Retrofit.NetworkModule
import kotlinx.android.synthetic.main.activity_outlet_isi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class outlet_isi : AppCompatActivity() {
//    private var data: List<DataItem> = ArrayList()
//    private var adapter: outlet_adapter? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_outlet_isi)
//        loadData()
//    }
//
//    private fun loadData() {
//        NetworkModule.getService()?.outlet()
//            ?.enqueue(object : Callback<ResponseOutlet> {
//                override fun onFailure(call: Call<ResponseOutlet>, t: Throwable) {
//                }
//
//                override fun onResponse(
//                    call: Call<ResponseOutlet>,
//                    response: ResponseObat1<ResponseOutlet>
//                ) {
//                    if (response.isSuccessful) {
//                        data=response.body()?.data!!
//                        adapter= outlet_adapter(data)
//                        val mLayoutManager= LinearLayoutManager(this@outlet_isi)
//                        rc_utama!!.layoutManager=mLayoutManager
//                        rc_utama!!.itemAnimator= DefaultItemAnimator()
//                        rc_utama!!.adapter=adapter
//                    }
//
//                }
//            })
//
//    }
//}