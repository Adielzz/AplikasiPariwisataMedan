package com.afahmi.lokamedan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookingFragment : Fragment() {

    private val bookingList = mutableListOf<BookingModel>()
    private lateinit var adapter: BookingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_booking, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.bookingRecyclerView)
        adapter = BookingAdapter(bookingList)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama = arguments?.getString("nama")
        val lokasi = arguments?.getString("lokasi")

        if (!nama.isNullOrEmpty() && !lokasi.isNullOrEmpty()) {
            bookingList.add(BookingModel(nama, lokasi))
            adapter.notifyDataSetChanged()
        }

        if (bookingList.isEmpty()) {
            bookingList.add(BookingModel("Danau Toba", "Sumatera Utara"))
            bookingList.add(BookingModel("Pantai Parbaba", "Samosir"))
            adapter.notifyDataSetChanged()
        }
    }
}
