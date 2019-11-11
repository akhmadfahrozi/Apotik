package com.e.apotik.transaksi


import com.google.gson.annotations.SerializedName


data class DataItem(

	@field:SerializedName("doctor_id")
	val doctorId: String? = null,

	@field:SerializedName("pay_amt")
	val payAmt: String? = null,

	@field:SerializedName("subtotal")
	val subtotal: String? = null,

	@field:SerializedName("staff_id")
	val staffId: String? = null,

	@field:SerializedName("tax")
	val tax: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("customer_id")
	val customerId: String? = null
)