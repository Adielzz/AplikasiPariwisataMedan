package com.afahmi.lokamedan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExploreFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExploreAdapter
    private val listWisata = mutableListOf<WisataModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        recyclerView = view.findViewById(R.id.recyclerExplore)

        // Inisialisasi adapter dengan listener klik
        adapter = ExploreAdapter(listWisata) { wisata ->
            bukaDetailFragment(wisata)
        }

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter

        isiDataDummy()
        return view
    }

    private fun bukaDetailFragment(wisata: WisataModel) {
        val bundle = Bundle().apply {
            putString("nama", wisata.nama)
            putString("lokasi", wisata.lokasi)
            putString("deskripsi", wisata.deskripsi)
            putInt("gambar", wisata.gambar)
        }

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun isiDataDummy() {
        listWisata.apply {
            add(
                WisataModel(
                    "Danau Toba",
                    "Sumatera Utara",
                    "Danau Toba adalah danau vulkanik terbesar di dunia dengan pemandangan alam yang memukau. Terbentuk sekitar 75.000 tahun lalu akibat letusan supervolcano, di tengah danau ini terdapat Pulau Samosir yang kaya akan budaya Batak.",
                    R.drawable.toba
                )
            )
            add(
                WisataModel(
                    "Kota Tua Medan",
                    "Medan",
                    "Kawasan bersejarah di Medan yang menyimpan bangunan-bangunan peninggalan kolonial Belanda. Gedung-gedung bergaya Eropa di sini menjadi saksi sejarah perkembangan kota sejak era penjajahan.",
                    R.drawable.oldtown_medan
                )
            )
            add(
                WisataModel(
                    "Istana Maimun",
                    "Medan",
                    "Istana Maimun adalah simbol kejayaan Kesultanan Deli, dibangun tahun 1888. Arsitekturnya merupakan perpaduan Melayu, Timur Tengah, India, dan Eropa. Istana ini kini menjadi objek wisata budaya dan sejarah populer.",
                    R.drawable.istanamaimun
                )
            )
            add(
                WisataModel(
                    "Masjid Raya Medan",
                    "Medan",
                    "Masjid Raya Al Mashun atau Masjid Raya Medan merupakan masjid termegah di kota Medan yang dibangun pada tahun 1906. Perpaduan arsitektur Timur Tengah, India, dan Spanyol menjadikannya landmark keagamaan dan wisata religi.",
                    R.drawable.sejarah_medan
                )
            )
            add(
                WisataModel(
                    "Balaikota Medan",
                    "Medan",
                    "Balaikota Medan adalah pusat administrasi pemerintahan kota yang juga memiliki nilai sejarah penting. Gedung berarsitektur kolonial ini menjadi ikon kota dan saksi perkembangan Medan sebagai kota metropolitan.",
                    R.drawable.balaikota
                )
            )
        }

        adapter.notifyDataSetChanged()
    }
}
