package com.e.apotik

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.apotik.Obatt.DataItem
import com.e.apotik.Obatt.ResponseObat
import com.e.apotik.Retrofit.NetworkModule
import kotlinx.android.synthetic.main.activity_obat.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Obat : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {//fungsi search
        when (p0?.id) {
            R.id.cari -> {
                NetworkModule.getService().cari_obat(cari_berita.text.toString())
                    .enqueue(object : Callback<ResponseObat> {
                        override fun onFailure(call: Call<ResponseObat>, t: Throwable) {
                        }

                        override fun onResponse(
                            call: Call<ResponseObat>,
                            response: Response<ResponseObat>
                        ) {
                            if (response.isSuccessful) {
                                data = response.body()?.data!!
                                data.sortedByDescending {
                                    it.name
                                }

                                data.forEach {
                                    print(it.name)
                                }
                                adapter = obat_adapter(data)
                                adapter?.notifyDataSetChanged()
                                try {//agar tidak force close ketika di klik berkali-kali
                                    val mLayoutManager = LinearLayoutManager(context)
                                    rc_obat!!.layoutManager = mLayoutManager
                                    rc_obat!!.itemAnimator = DefaultItemAnimator()
                                    rc_obat!!.adapter = adapter

                                } catch (e: Exception) {

                                }
                            }
                        }
                    })
            }
        }
    }

    private var data: List<DataItem> = mutableListOf()
    private var adapter: obat_adapter? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_obat)
//        loadData()
//
//
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadData()
        return inflater.inflate(R.layout.activity_obat, null);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cari.setOnClickListener(this)

//tambahannya ini
        softby.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var sortedList:List<DataItem> = mutableListOf()
                if(p2 == 1){
                     sortedList = data.sortedWith(compareByDescending { it.price })

                }else if (p2 == 2){
                     sortedList = data.sortedWith(compareBy { it.name })
                }else if(p2 == 3){
                    sortedList = data.sortedWith(compareByDescending { it.name })
                }


                adapter = obat_adapter(sortedList)
                adapter?.notifyDataSetChanged()
                rc_obat.adapter = adapter


            }

        }
    }


    private fun loadData() {
        NetworkModule.getService().obat()
            .enqueue(object : Callback<ResponseObat> {
                override fun onFailure(call: Call<ResponseObat>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<ResponseObat>,
                    response: Response<ResponseObat>
                ) {
                    if (response.isSuccessful) {
                        data = response.body()?.data!!
                        adapter = obat_adapter(data)
                        try {//agar tidak force close ketika di klik berkali-kali
                            val mLayoutManager = LinearLayoutManager(context)
                            rc_obat!!.layoutManager = mLayoutManager
                            rc_obat!!.itemAnimator = DefaultItemAnimator()
                            rc_obat!!.adapter = adapter

                        } catch (e: Exception) {

                        }

                    }

                }

            })

    }

}