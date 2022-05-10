package hr.algebra.evenq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import hr.algebra.evenq.databinding.ActivityScannerBinding

class ScannerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScannerBinding
    private lateinit var codeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        codeScanner = CodeScanner(this, binding.scannerView).apply {
            this.camera = CodeScanner.CAMERA_BACK
            this.formats = CodeScanner.ALL_FORMATS
            this.autoFocusMode = AutoFocusMode.SAFE
            this.scanMode = ScanMode.SINGLE
            this.isAutoFocusEnabled = true
            this.isFlashEnabled = false
        }

        codeScanner.decodeCallback = DecodeCallback {
            Toast.makeText(this, "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            Toast.makeText(
                this, "Camera initialization error: ${it.message}",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
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