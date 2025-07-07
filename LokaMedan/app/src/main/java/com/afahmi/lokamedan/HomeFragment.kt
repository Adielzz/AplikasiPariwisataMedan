package com.afahmi.lokamedan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Danau Toba
        val cardDanauToba = view.findViewById<CardView>(R.id.cardDanauToba)
        cardDanauToba.setOnClickListener {
            val bundle = Bundle().apply {
                putString("nama", "Danau Toba")
                putString("lokasi", "Sumatera Utara")
                putString("deskripsi", "Danau Toba adalah danau vulkanik terbesar di Indonesia bahkan di dunia, terbentuk dari letusan gunung berapi purba sekitar 75 ribu tahun lalu. Di tengahnya terdapat Pulau Samosir yang kaya budaya Batak dan pemandangan luar biasa.")
                putInt("gambar", R.drawable.toba)
            }
            bukaDetail(bundle)
        }

        // Istana Maimun
        val cardIstanaMaimun = view.findViewById<CardView>(R.id.istanamaimun)
        cardIstanaMaimun.setOnClickListener {
            val bundle = Bundle().apply {
                putString("nama", "Istana Maimun")
                putString("lokasi", "Medan, Sumatera Utara")
                putString("deskripsi", "Istana Maimun adalah ikon kota Medan peninggalan Kesultanan Deli, dibangun tahun 1888 oleh Sultan Ma'mun Al Rasyid Perkasa Alamsyah. Arsitekturnya memadukan unsur Melayu, Timur Tengah, India, hingga Eropa. Kini, istana ini menjadi destinasi wisata budaya dan sejarah.")
                putInt("gambar", R.drawable.istanamaimun)
            }
            bukaDetail(bundle)
        }

        // Kota Tua Medan
        val cardOldTown = view.findViewById<CardView>(R.id.cardOldTown)
        cardOldTown.setOnClickListener {
            val bundle = Bundle().apply {
                putString("nama", "Kota Tua Medan")
                putString("lokasi", "Medan, Sumatera Utara")
                putString("deskripsi", "Kawasan Kota Tua Medan menyimpan jejak sejarah kolonial Belanda dengan gedung-gedung berarsitektur khas Eropa yang masih berdiri kokoh, seperti Gedung London Sumatera dan Gedung Tua Kesawan. Tempat ini cocok untuk wisata sejarah dan fotografi.")
                putInt("gambar", R.drawable.oldtown_medan)
            }
            bukaDetail(bundle)
        }

        // Masjid Raya Medan
        val cardMasjid = view.findViewById<CardView>(R.id.Masjid)
        cardMasjid.setOnClickListener {
            val bundle = Bundle().apply {
                putString("nama", "Masjid Raya Al Mashun")
                putString("lokasi", "Medan, Sumatera Utara")
                putString("deskripsi", "Masjid Raya Al Mashun adalah masjid terbesar dan termegah di kota Medan, dibangun pada tahun 1906. Masjid ini terkenal dengan arsitektur bergaya Timur Tengah, India, dan Spanyol, serta menjadi pusat aktivitas keagamaan umat Muslim di Medan.")
                putInt("gambar", R.drawable.sejarah_medan)
            }
            bukaDetail(bundle)
        }

        // Balaikota Medan
        val cardBalaikota = view.findViewById<CardView>(R.id.balaikota)
        cardBalaikota.setOnClickListener {
            val bundle = Bundle().apply {
                putString("nama", "Balaikota Medan")
                putString("lokasi", "Medan, Sumatera Utara")
                putString("deskripsi", "Balaikota Medan adalah pusat pemerintahan Kota Medan yang dibangun sejak masa kolonial. Gedung ini menjadi saksi sejarah perkembangan administrasi kota dan merupakan salah satu landmark bersejarah yang masih terawat hingga kini.")
                putInt("gambar", R.drawable.balaikota)
            }
            bukaDetail(bundle)
        }

        // Card Sejarah Kota Medan
        val sejarahCard = view.findViewById<CardView>(R.id.sejarahCard)
        sejarahCard.setOnClickListener {
            val intent = Intent(requireContext(), DetailSejarahActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    private fun bukaDetail(bundle: Bundle) {
        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}
