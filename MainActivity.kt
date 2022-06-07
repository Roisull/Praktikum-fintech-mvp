package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var btnHitungLuas: Button
    private lateinit var btnHitungKeliling: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        mainPresenter = MainPresenter(this)
        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        btnHitungKeliling = findViewById(R.id.btn_hitungKeliling)
        btnHitungLuas = findViewById(R.id.btn_hitungLuas)
        tvHasil = findViewById(R.id.tv_hasil)
        
        btnHitungLuas.setOnClickListener{
            val panjang = etPanjang.text.toString()
            val lebar = etLebar.text.toString()
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
        TODO("Not yet implemented")
    }
}

