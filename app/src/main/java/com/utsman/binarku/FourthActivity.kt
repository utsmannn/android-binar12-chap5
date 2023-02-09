package com.utsman.binarku

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.google.android.material.snackbar.Snackbar
import com.utsman.binarku.databinding.ActivityFourBinding

class FourthActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFourBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCamera.setOnClickListener {
            startCamera()
        }

        binding.btnMainActivity.setOnClickListener {
            startMainActivity()
        }

        binding.btnService.setOnClickListener {
            startSimpleService()
        }

        binding.btnIntentData.setOnClickListener {
            startFiveActivity()
        }

        binding.btnLogin.setOnClickListener {
            startLogin()
        }

        binding.btnBulkData.setOnClickListener {
            startSendBulkData()
        }

        binding.btnSerializable.setOnClickListener {
            startSendSerial()
        }

        binding.btnParcel.setOnClickListener {
            startSendParcel()
        }

        binding.btnToast.setOnClickListener {
            toast("ini toast")
        }

        binding.btnSnackbar.setOnClickListener {
            val snackbar = Snackbar.make(binding.root, "ini snackbar", Snackbar.LENGTH_SHORT)
            snackbar.setAction(R.string.action_1) {
                snackbar.dismiss()
            }
            /*snackbar.setAction("toast") {
                toast("toast ini")
            }*/
            snackbar.show()
        }

    }

    // implisit intent
    private fun startCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val intentChooser = Intent.createChooser(intent, "pilih aplikasi")
        startActivity(intentChooser)
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun startSimpleService() {
        val intent = Intent(this, SimpleServices::class.java)
        startService(intent)
    }

    private fun startFiveActivity() {
        val intent = Intent(this, FiveActivity::class.java)
        intent.putExtra("data_nya", "ini data nya dari activity sebelah")
        startActivity(intent)
    }

    private fun startLogin() {
        val username = binding.tvUsername.text.toString()
        val intent = Intent(this, FiveActivity::class.java)
        intent.putExtra("data_nya", username)
        startActivity(intent)
    }

    private fun startSendBulkData() {
        val intent = Intent(this, FiveActivity::class.java)
        val bundle = bundleOf(
            "data1" to "ini data satu",
            "data2" to "ini data dua",
            "data3integer" to 3
        )
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun startSendSerial() {
        val user = User("anton", "1234")
        val intent = Intent(this, FiveActivity::class.java)
        intent.putExtra("data_user", user)
        startActivity(intent)
    }

    private fun startSendParcel() {
        val person = Person("ucup", 21)
        val intent = Intent(this, FiveActivity::class.java)
        intent.putExtra("data_person", person)
        startActivity(intent)
    }
}