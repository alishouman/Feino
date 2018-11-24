package com.example.android.feino.fragment

import android.widget.Toast
import com.google.android.gms.vision.barcode.Barcode
import android.util.SparseArray
import info.androidhive.barcode.BarcodeReader
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import com.example.android.feino.R
import kotlinx.android.synthetic.main.fragment_barcode.*


class BarcodeFragment : FeinoBaseFragment(), BarcodeReader.BarcodeReaderListener {

    lateinit private var barcodeReader: BarcodeReader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?{
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_barcode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        barcodeReader= childFragmentManager.findFragmentById(R.id.barcode_fragment) as BarcodeReader
        barcodeReader.setListener(this)
    }
    override fun onScanned(barcode: Barcode) {
        Log.e(TAG, "onScanned: " + barcode.displayValue)
        barcodeReader!!.playBeep()

        activity?.runOnUiThread {
            Toast.makeText(
                activity,
                "Barcode: " + barcode.displayValue,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onScannedMultiple(barcodes: List<Barcode>) {
        Log.e(TAG, "onScannedMultiple: " + barcodes.size)

        var codes = ""
        for (barcode in barcodes) {
            codes += barcode.displayValue + ", "
        }

        val finalCodes = codes
        activity?.runOnUiThread {
            Toast.makeText(
                activity,
                "Barcodes: $finalCodes",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onBitmapScanned(sparseArray: SparseArray<Barcode>) {

    }

    override fun onScanError(errorMessage: String) {
        Log.e(TAG, "onScanError: $errorMessage")
    }

    override fun onCameraPermissionDenied() {
        Toast.makeText(getActivity(), "Camera permission denied!", Toast.LENGTH_LONG).show()
    }

    companion object {
        private val TAG = BarcodeFragment::class.java.simpleName
    }
}// Required empty public constructor