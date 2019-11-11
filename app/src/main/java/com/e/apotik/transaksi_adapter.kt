package com.e.apotik

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.apotik.transaksi.DataItem

class transaksi_adapter(private val model: List<DataItem>) :
    RecyclerView.Adapter<transaksi_adapter.ViewHolder>() {
    private var ct: Context? = null
    override fun onBindViewHolder(holder: transaksi_adapter.ViewHolder, position: Int) {
        val data = model[position]
        holder.tv_judul.text = data.id//nampilkan judul
        holder.tv_alamat.text = data.staffId
        holder.tv_isi.text = data.customerId
        holder.tv_doctor.text = data.doctorId
        holder.tv_subtotal.text = data.subtotal
        holder.t_tax.text =data.tax
        holder.t_pay.text =data.payAmt
        // holder.tv_view.text=data.viewer
        //nampilkan isi utama
        ct?.let {

        }//menampilkan gambar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val L = LayoutInflater.from(parent.context)
        val V = L.inflate(R.layout.activity_transaksi_adapter, parent, false)
        ct = parent.context
        return ViewHolder(V)

    }

    override fun getItemCount(): Int {
        return model.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_judul: TextView = itemView.findViewById(R.id.tv_id)
        internal var tv_alamat: TextView = itemView.findViewById(R.id.staff)
        internal var tv_isi: TextView = itemView.findViewById(R.id.customer)
        internal var tv_doctor: TextView = itemView.findViewById(R.id.doctor_id)
        internal var tv_subtotal: TextView = itemView.findViewById(R.id.subtotal)
        internal var t_tax: TextView = itemView.findViewById(R.id.tax)
        internal var t_pay: TextView = itemView.findViewById(R.id.pay)
        //internal var iv_gambar: ImageView = itemView.findViewById(R.id.iv_gambar)
    }


}
