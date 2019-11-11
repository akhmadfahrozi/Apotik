package com.e.apotik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.apotik.Retrofit.NetworkModule
import com.e.apotik.transaksi.DataItem
import com.e.apotik.transaksi.ResponseTransaksi
import kotlinx.android.synthetic.main.activity_transaksi_isi.*
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class transaksi_isi : AppCompatActivity(),View.OnClickListener {
    override fun onClick(p0: View?) {

    }

    private var data: List<DataItem> = ArrayList()
    private var adapter: transaksi_adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi_isi)
        loadData()
    }

    private fun loadData() {
        NetworkModule.getService().transaksi()
            .enqueue(object : Callback<ResponseTransaksi> {
                override fun onFailure(call: Call<ResponseTransaksi>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<ResponseTransaksi>,
                    response: Response<ResponseTransaksi>
                ) {
                    if (response.isSuccessful) {
                        data=response.body()?.data!!
                        adapter= transaksi_adapter(data)
                        val mLayoutManager= LinearLayoutManager(this@transaksi_isi)
                        rc_isi!!.layoutManager=mLayoutManager
                        rc_isi!!.itemAnimator= DefaultItemAnimator()
                        rc_isi!!.adapter=adapter
                    }

                }
            })

    }
}
