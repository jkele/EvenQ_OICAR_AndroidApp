package hr.algebra.evenq.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import hr.algebra.evenq.R
import hr.algebra.evenq.SignInActivity
import hr.algebra.evenq.databinding.FragmentAccountBinding

private lateinit var mAuth: FirebaseAuth

class AccountFragment: Fragment(R.layout.fragment_account) {

    private lateinit var binding: FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        mAuth = FirebaseAuth.getInstance()

        //binding.testPlaceHolderinjo.text = mAuth.currentUser!!.email

        binding.testPlaceHolderinjo.text = mAuth.currentUser!!.uid

        mAuth.currentUser!!.uid

        setLogoutListener()

        return binding.root
    }

    private fun setLogoutListener() {
        binding.btnLogout.setOnClickListener {
            mAuth.signOut()
            val intent = Intent(requireContext(), SignInActivity::class.java)
            requireContext().startActivity(intent)
            requireActivity().finish()
        }
    }

}