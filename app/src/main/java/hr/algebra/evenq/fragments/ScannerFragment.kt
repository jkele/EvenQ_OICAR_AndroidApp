package hr.algebra.evenq.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import hr.algebra.evenq.R
import hr.algebra.evenq.databinding.FragmentScannerBinding

class ScannerFragment: Fragment(R.layout.fragment_scanner) {

    private lateinit var binding: FragmentScannerBinding
    private lateinit var codeScanner: CodeScanner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScannerBinding.inflate(inflater, container, false)

        codeScanner = CodeScanner(requireContext(), binding.scannerView).apply {
            this.camera = CodeScanner.CAMERA_BACK
            this.formats = CodeScanner.ALL_FORMATS
            this.autoFocusMode = AutoFocusMode.SAFE
            this.scanMode = ScanMode.SINGLE
            this.isAutoFocusEnabled = true
            this.isFlashEnabled = false
        }

        codeScanner.decodeCallback = DecodeCallback {
            Toast.makeText(requireContext(), "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            Toast.makeText(
                requireContext(), "Camera initialization error: ${it.message}",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

}