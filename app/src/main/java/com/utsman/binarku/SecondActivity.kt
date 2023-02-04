package com.utsman.binarku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private var myFlag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        println("BINAR -> onCreate")
        myFlag = 0
        showToast("Halo selamat datang di aplikasi binarku")

        val btnMove: Button = findViewById(R.id.btn_move)
        btnMove.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        println("BINAR -> onStart")
        if (myFlag != 0) {
            showToast("Selamat datang kembali")
        }
    }

    override fun onResume() {
        super.onResume()
        println("BINAR -> onResume")
    }

    override fun onPause() {
        super.onPause()
        println("BINAR -> onPaused")
    }

    override fun onStop() {
        super.onStop()
        myFlag = 1
        println("BINAR -> onStop")
        showToast("Dadah, jangan lupa balik lagi")
    }

    override fun onDestroy() {
        println("BINAR -> onDestroy")
        showToast("Selamat tinggal")
        super.onDestroy()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}