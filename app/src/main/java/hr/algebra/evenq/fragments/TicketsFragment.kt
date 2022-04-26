package hr.algebra.evenq.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import hr.algebra.evenq.R
import hr.algebra.evenq.adapters.TicketItemRecyclerAdapter
import hr.algebra.evenq.databinding.FragmentTicketsBinding
import hr.algebra.evenq.viewmodels.TicketsViewModel

class TicketsFragment: Fragment(R.layout.fragment_tickets) {

    private lateinit var binding: FragmentTicketsBinding

    private val viewModel: TicketsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketsBinding.inflate(inflater, container, false)

        binding.rvTickets.layoutManager = LinearLayoutManager(requireContext())

        viewModel.ticketsList.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = ProgressBar.VISIBLE

            val adapter = TicketItemRecyclerAdapter(requireContext(), it)
            binding.rvTickets.adapter = adapter

            binding.progressBar.visibility = ProgressBar.INVISIBLE
        })

        val data: String = "c"

        binding.swipeContainer.setOnRefreshListener {
            viewModel.getTicketsForMember(data)
            binding.swipeContainer.isRefreshing = false
        }

        viewModel.getTicketsForMember(data)

        return binding.root
    }

}