package com.e.apotik.transaksi


import com.google.gson.annotations.SerializedName


data class ResponseTransaksi(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
)