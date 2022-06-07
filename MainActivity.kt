package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var btnHitungLuas: Button
    private lateinit var btnHitungKeliling: Button
    private lateinit var tvHasil: TextView
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide(); // hide the action bar

        window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN) // hide status bar

        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        btnHitungKeliling = findViewById(R.id.btn_hitungKeliling)
        btnHitungLuas = findViewById(R.id.btn_hitungLuas)
        tvHasil = findViewById(R.id.tv_hasil)

        btnHitungLuas.setOnClickListener{
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungLuasPersegiPanjang(panjang, lebar)
        }

        btnHitungKeliling.setOnClickListener{
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungKelilingPersegiPanjang(panjang, lebar)
        }

    }

    override fun updateLuas(luas: Float) {
        tvHasil.text = luas.toString()
    }

    override fun updateKeliling(keliling: Float) {
        tvHasil.text = keliling.toString()
    }

    override fun showError(errorMsg: String) {
        tvHasil.text = errorMsg
    }
}
