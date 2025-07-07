package com.afahmi.lokamedan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val img = view.findViewById<ImageView>(R.id.detailImage)
        val nama = view.findViewById<TextView>(R.id.detailNama)
        val lokasi = view.findViewById<TextView>(R.id.detailLokasi)
        val deskripsi = view.findViewById<TextView>(R.id.detailDeskripsi)
        val btnBooking = view.findViewById<Button>(R.id.btnBooking)

        val args = arguments
        val namaWisata = args?.getString("nama") ?: "Wisata"
        val lokasiWisata = args?.getString("lokasi") ?: "Lokasi"
        val deskripsiWisata = args?.getString("deskripsi") ?: "Deskripsi belum tersedia"
        val gambarResId = args?.getInt("gambar") ?: R.drawable.toba

        img.setImageResource(gambarResId)
        nama.text = namaWisata
        lokasi.text = lokasiWisata
        deskripsi.text = deskripsiWisata

        btnBooking.setOnClickListener {
            val bundle = Bundle().apply {
                putString("nama", namaWisata)
                putString("lokasi", lokasiWisata)
            }

            val bookingFragment = BookingFragment()
            bookingFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, bookingFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
