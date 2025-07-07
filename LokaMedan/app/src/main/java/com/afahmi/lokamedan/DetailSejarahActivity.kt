package com.afahmi.lokamedan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afahmi.lokamedan.databinding.ActivityDetailSejarahBinding

class DetailSejarahActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSejarahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSejarahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.judulTextView.text = "Sejarah Kota Medan"

        binding.isiTextView.text = """
Kota Medan adalah ibu kota provinsi Sumatera Utara sekaligus kota terbesar di Pulau Sumatera.

Pada masa penjajahan, Medan menjadi pusat Kesultanan Deli yang berdiri sejak abad ke-17. Awalnya, wilayah ini merupakan kawasan rawa dan hutan, kemudian berkembang pesat setelah kedatangan bangsa Belanda yang membuka perkebunan tembakau di kawasan Deli, dikenal dengan sebutan Deli Tobacco yang terkenal di Eropa.

Selama era kolonial, infrastruktur seperti pelabuhan Belawan dan jalur kereta api dibangun, menjadikan Medan pusat perdagangan utama di Sumatera. Banyak bangunan bergaya arsitektur Eropa masih dapat ditemukan, seperti Istana Maimun, Masjid Raya Al-Mashun, dan gedung Balai Kota lama.

Pasca kemerdekaan, Medan terus berkembang menjadi kota metropolitan, pusat industri, pendidikan, dan pariwisata.

Saat ini, Medan dikenal sebagai kota multikultural dengan penduduk yang terdiri dari berbagai suku, termasuk Melayu, Batak, Tionghoa, Jawa, dan lain-lain.

Wali Kota Medan saat ini adalah Rico Tri Putra Bayu Waas, yang menjabat sejak tahun 2025 bersama wakilnya, H. Zakiyuddin Harahap. Di bawah kepemimpinan mereka, Kota Medan terus berbenah dalam bidang infrastruktur, pariwisata, dan peningkatan kualitas pelayanan publik.
        """.trimIndent()
    }
}
