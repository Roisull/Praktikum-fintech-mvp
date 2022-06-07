package com.example.mvp
// membuat class MainPresenter.kt
class MainPresenter(private val mainView: MainView) {
    fun hitungLuasPersegiPanjang(panjang: Float, lebar: Float){
        if(panjang == 0F || panjang == null){
            mainView.showError("Panjang tidak boleh 0")
            return
        }
        if(lebar == 0F || lebar == null){
            mainView.showError("Lebar tidak boleh 0")
            return
        }

        val luas = panjang * lebar
        mainView.updateLuas(luas)
    }

    fun hitungKelilingPersegiPanjang(panjang: Float, lebar: Float){
        if(panjang == 0F || panjang == null){
            mainView.showError("Panjang tidak boleh 0")
            return
        }
        if(lebar == 0F || lebar == null){
            mainView.showError("Lebar tidak boleh 0")
            return
        }

        val keliling = 2*(panjang+lebar)
        mainView.updateKeliling(keliling)
    }
}
