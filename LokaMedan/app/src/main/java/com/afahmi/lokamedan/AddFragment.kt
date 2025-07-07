package com.afahmi.lokamedan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val namaInput = view.findViewById<EditText>(R.id.inputNamaWisata)
        val lokasiInput = view.findViewById<EditText>(R.id.inputLokasiWisata)
        val btnTambah = view.findViewById<Button>(R.id.btnTambahBooking)

        btnTambah.setOnClickListener {
            val namaWisata = namaInput.text.toString().trim()
            val lokasiWisata = lokasiInput.text.toString().trim()

            if (namaWisata.isNotEmpty() && lokasiWisata.isNotEmpty()) {
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
            } else {
                Toast.makeText(requireContext(), "Isi semua data dulu!", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
