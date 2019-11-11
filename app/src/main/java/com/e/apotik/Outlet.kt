package com.e.apotik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.apotik.Model.DataItem
import com.e.apotik.Model.ResponseOutlet
import com.e.apotik.Retrofit.NetworkModule
import kotlinx.android.synthetic.main.activity_outlet.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Outlet : Fragment(),View.OnClickListener {
    override fun onClick(p0: View?) {
        when(p0?.id){//disamakan di load data
            R.id.cari->{
                NetworkModule.getService().cari(cari_berita.text.toString())
                    .enqueue(object : Callback<ResponseOutlet> {
                        override fun onFailure(call: Call<ResponseOutlet>, t: Throwable) {
                        }

                        override fun onResponse(
                            call: Call<ResponseOutlet>,
                            response: Response<ResponseOutlet>//Response retrofit 2
                        ) {
                            if (response.isSuccessful) {
                                data = response.body()?.data!!
                                adapter = outlet_adapter(data)

                                try {

                                    val mLayoutManager =LinearLayoutManager(context)//harus contex apabila fragment//
                                    rc_utama!!.layoutManager = mLayoutManager//apabila bikin di activity baru
                                    rc_utama!!.itemAnimator = DefaultItemAnimator()
                                    rc_utama!!.adapter = adapter

                                }catch (e:Exception){


                                }
//                        val mLayoutManager =LinearLayoutManager(context)//harus contex apabila fragment//
//                        rc_utama!!.layoutManager = mLayoutManager//apabila bikin di activity baru menggunakan ini
//                        rc_utama!!.itemAnimator = DefaultItemAnimator()
//                        rc_utama!!.adapter = adapter
                            }

                        }

                    })


            }


        }


    }

    private var data: List<DataItem> = ArrayList()
    private var adapter: outlet_adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        //load data harus di atas return
        return inflater.inflate(R.layout.activity_outlet, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       loadData()

        cari.setOnClickListener(this)
    }




    private fun loadData() {//callback retrofit 2
        NetworkModule.getService().outlet()
            .enqueue(object : Callback<ResponseOutlet> {
                override fun onFailure(call: Call<ResponseOutlet>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<ResponseOutlet>,
                    response: Response<ResponseOutlet>//Response retrofit 2
                ) {
                    if (response.isSuccessful) {
                        data = response.body()?.data!!
                        adapter = outlet_adapter(data)

                        try {

                            val mLayoutManager =LinearLayoutManager(context)//harus contex apabila fragment//
                            rc_utama!!.layoutManager = mLayoutManager//apabila bikin di activity baru
                            rc_utama!!.itemAnimator = DefaultItemAnimator()
                            rc_utama!!.adapter = adapter

                        }catch (e:Exception){


                        }
//                        val mLayoutManager =LinearLayoutManager(context)//harus contex apabila fragment//
//                        rc_utama!!.layoutManager = mLayoutManager//apabila bikin di activity baru menggunakan ini
//                        rc_utama!!.itemAnimator = DefaultItemAnimator()
//                        rc_utama!!.adapter = adapter
                    }

                }

            })

    }
}