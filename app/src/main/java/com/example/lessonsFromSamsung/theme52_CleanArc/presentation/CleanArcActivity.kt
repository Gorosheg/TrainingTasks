package com.example.lessonsFromSamsung.theme52_CleanArc.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.lessonsFromSamsung.R
import com.example.lessonsFromSamsung.theme52_CleanArc.presentation.TaskActivity.Companion.MY_TEXT_ARG
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CleanArcActivity : AppCompatActivity(), OnRequestPermissionsResultCallback {

    private val viewModel: CleanArcViewModel by viewModel {
        val myText = intent.getStringExtra(MY_TEXT_ARG)
        parametersOf(myText, 6)
    }

    private var disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_52_clean)

        val edit: EditText = findViewById(R.id.some_text)
        val showText: TextView = findViewById(R.id.show_saving_text)

        disposable += viewModel.data
            .subscribe {
                showText.text = it
            }

        disposable += viewModel.myText
            .subscribe {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }

        edit.addTextChangedListener {
            val text = it.toString()
            viewModel.saveData(text)
        }

        enableMyLocation()

    }

    private fun enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            // ???????????????????? ?????????? ???? ??????????????????????
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            return
        }
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            enableMyLocation()
        } else {
            // ???????????? ??????-???? ???? ??????????????
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

}