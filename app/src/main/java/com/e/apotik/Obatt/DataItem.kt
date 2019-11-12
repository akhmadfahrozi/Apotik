package com.e.apotik.Obatt


import com.google.gson.annotations.SerializedName


data class DataItem(

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("meds_type_id")
	val medsTypeId: String? = null
)