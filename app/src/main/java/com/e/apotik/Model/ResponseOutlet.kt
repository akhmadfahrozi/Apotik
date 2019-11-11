package com.e.apotik.Model


import com.google.gson.annotations.SerializedName


data class ResponseOutlet(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
)