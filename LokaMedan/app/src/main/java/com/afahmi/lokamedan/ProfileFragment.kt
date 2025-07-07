package com.afahmi.lokamedan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val namaText = view.findViewById<TextView>(R.id.namaProfile)
        val emailText = view.findViewById<TextView>(R.id.emailProfile)
        val deskripsiText = view.findViewById<TextView>(R.id.deskripsiProfile)
        val fotoProfile = view.findViewById<ImageView>(R.id.profileImage)

        // Isi data profile kamu
        namaText.text = "Ahmad Fahmi Abdillah"
        emailText.text = "fahmi@email.com"
        deskripsiText.text = "Mahasiswa Teknik Informatika, pecinta teknologi dan Android enthusiast."

        return view
    }
}
