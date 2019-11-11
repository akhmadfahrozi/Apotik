package com.e.apotik.Model


import com.google.gson.annotations.SerializedName


data class DataItem(

	@field:SerializedName("phone_no")
	val phoneNo: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)