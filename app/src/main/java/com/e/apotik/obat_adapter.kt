package com.e.apotik

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.apotik.Obatt.DataItem

class obat_adapter(private val model: List<DataItem>) :
    RecyclerView.Adapter<obat_adapter.ViewHolder>() {
    private var ct: Context? = null
    override fun onBindViewHolder(holder: obat_adapter.ViewHolder, position: Int) {
        val data = model[position]
        holder.tv_judul.text = data.name//nampilkan judul
        holder.tv_alamat.text = data.price
        // holder.tv_view.text=data.viewer
        holder.tv_nohp.text=data.medsTypeId//nampilkan isi utama
        ct?.let {

            //            Glide.with(it).load(NetworkModule.BASE_URL + "assets/gambar/${data.gambar}")
//                .into(holder.iv_gambar)
        }//menampilkan gambar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val L = LayoutInflater.from(parent.context)
        val V = L.inflate(R.layout.activity_obat_adapter, parent, false)
        ct = parent.context
        return ViewHolder(V)

    }

    override fun getItemCount(): Int {
        return model.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_judul: TextView = itemView.findViewById(R.id.tv_nama_obat)
        internal var tv_alamat: TextView = itemView.findViewById(R.id.tv_price)
        internal var tv_nohp: TextView = itemView.findViewById(R.id.tv_type)
        //  internal var tv_view:TextView=itemView.findViewById(R.id.tv_viewer)
        //internal var iv_gambar: ImageView = itemView.findViewById(R.id.iv_gambar)
    }


}
