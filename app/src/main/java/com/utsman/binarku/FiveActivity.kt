package com.utsman.binarku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.utsman.binarku.databinding.ActivityFiveBinding

class FiveActivity : AppCompatActivity() {

    private val binding: ActivityFiveBinding by lazy { ActivityFiveBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundleReceived = intent.extras
        val stringIncoming = intent.getStringExtra("data_nya")
        val userSerial = intent.getSerializableExtra("data_user") as? User
        val personParcel = intent.getParcelableExtra<Person>("data_person")

        println("BINARKU -------------> $userSerial")
        println("BINARKU bundle -------------> ${bundleReceived?.getString("data1") != null}")

        if (stringIncoming != null) {
            binding.tvResult.text = stringIncoming
        }

        if (bundleReceived?.getString("data1") != null) {
            val data1 = bundleReceived.getString("data1")
            val data2 = bundleReceived.getString("data2")
            val data3Integer = bundleReceived.getInt("data3integer")
            val textResult = "$data1\n$data2\n$data3Integer"
            binding.tvResult.text = textResult
        }

        if (userSerial != null) {
            binding.tvResult.text = userSerial.name
        }

        if (personParcel != null) {
            binding.tvResult.text = personParcel.name
        }

        binding.btnBack.setOnClickListener {
            //onBackPressed()
            finish()
        }
    }
}