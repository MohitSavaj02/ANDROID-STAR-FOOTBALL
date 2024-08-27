package com.example.baseproject.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.baseproject.dialog.LoadingDialog
import com.example.baseproject.utils.PrefUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
abstract class BaseFragment : Fragment() {
    @Inject
    lateinit var mPrefUtils: PrefUtils
    lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingDialog = LoadingDialog(requireContext())
    }

    fun showProgress() {
        requireActivity().runOnUiThread {
            try {
                loadingDialog.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    fun hideProgress() {
        try {
            requireActivity().runOnUiThread { loadingDialog.dismiss() }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showToast(data: Any?) {
        Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_SHORT).show()
    }

    fun printData(data: Any?) {
        Log.e("The_Wolf", "printData: $data")
    }

    fun printData(key: String, data: Any?) {
        Log.e("The_Wolf", "$key------------->: $data")
    }
}
