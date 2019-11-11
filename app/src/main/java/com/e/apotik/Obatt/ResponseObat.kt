package com.e.apotik.Obatt


import com.google.gson.annotations.SerializedName


data class ResponseObat(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
)