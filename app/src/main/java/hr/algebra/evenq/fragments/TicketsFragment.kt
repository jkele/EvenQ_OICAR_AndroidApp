package hr.algebra.evenq.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.algebra.evenq.R
import hr.algebra.evenq.databinding.FragmentTicketsBinding

class TicketsFragment: Fragment(R.layout.fragment_tickets) {

    private lateinit var binding: FragmentTicketsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketsBinding.inflate(inflater, container, false)

        return binding.root
    }

}