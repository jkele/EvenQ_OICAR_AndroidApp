package hr.algebra.evenq

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import hr.algebra.evenq.databinding.ActivityMainBinding
import hr.algebra.evenq.framework.startActivity

private lateinit var binding: ActivityMainBinding
private lateinit var mAuth: FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mAuth = FirebaseAuth.getInstance()
        setContentView(binding.root)
        setListeners()

        //ovo maknut joza samo tek tolko da znas kak sing out i te glupost
        binding.testPlaceHolderinjo.text = mAuth.currentUser!!.email
    }

    private fun setListeners() {
        binding.btnLogout.setOnClickListener {
            mAuth.signOut()
            startActivity<SignInActivity>()
            finish()
        }
    }
}