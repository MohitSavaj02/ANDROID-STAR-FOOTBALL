package com.example.baseproject.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.baseproject.dialog.LoadingDialog
import com.example.baseproject.utils.PrefUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var mPrefUtils: PrefUtils
    lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingDialog = LoadingDialog(this)
    }

    fun showProgress() {
        runOnUiThread {
            try {
                loadingDialog.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    fun hideProgress() {
        try {
            runOnUiThread { loadingDialog.dismiss() }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showToast(data: Any?) {
        Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show()
    }

    fun printData(data: Any?) {
        Log.e("The_Wolf", "printData: $data")
    }

    fun printData(key: String, data: Any?) {
        Log.e("The_Wolf", "$key------------->: $data")
    }
}
