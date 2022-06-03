package com.example.android_intent_learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_intent_learning.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: SecondActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val passData = intent.getStringExtra("pass_data") ?: ""
        Toast.makeText(this, passData, Toast.LENGTH_LONG).show()

        binding.button2.setOnClickListener {
            val data: String = "Hello, First Activity"
            val returnIntent = Intent()
            returnIntent.putExtra("return_data", data)
            setResult(RESULT_OK, returnIntent)

            // close activity
            finish()
        }
    }
}