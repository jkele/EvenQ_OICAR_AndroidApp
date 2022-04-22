package hr.algebra.evenq

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import hr.algebra.evenq.databinding.ActivitySignInBinding
import hr.algebra.evenq.framework.showToast
import hr.algebra.evenq.framework.startActivity


private lateinit var binding: ActivitySignInBinding
private lateinit var mAuth: FirebaseAuth

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        mAuth = FirebaseAuth.getInstance()
        checkForUser()
        setContentView(binding.root)
        setListeners()
    }

    private fun checkForUser() {
        if (mAuth.currentUser != null) startActivity<MainActivity>()
    }

    private fun setListeners() {
        binding.btnLogin.setOnClickListener {
            if (isDataValid()) {
                signIn()
            }
        }
    }

    private fun signIn() {

        mAuth.signInWithEmailAndPassword(
            binding.etEmail.text.toString().trim(),
            binding.etPassword.text.toString().trim()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    if (mAuth.currentUser!!.isEmailVerified) {
                        startActivity<MainActivity>()
                    } else {
                        mAuth.signOut()
                        showToast("Email not verified.")
                    }
                } else {
                    showToast("Authentication failed.")
                }
            }

    }

    private fun isDataValid(): Boolean {

        if (binding.etEmail.text.toString().trim().isEmpty()) {
            showToast("Enter email")
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString().trim())
                .matches()
        ) {
            showToast("Enter valid email")
            return false
        } else if (binding.etEmail.text.toString().trim().isEmpty()) {
            showToast("Enter passworrd")
            return false
        }
        return true
    }
}