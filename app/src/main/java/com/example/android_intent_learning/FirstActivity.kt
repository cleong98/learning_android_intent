package com.example.android_intent_learning

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.android_intent_learning.databinding.FirstActivityBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: FirstActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FirstActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener {
            val data = "Hello, Second Activity"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("pass_data", data)
            getActivityResult.launch(intent)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // set menu view
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_LONG).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_LONG).show()
        }
        return true
    }

    private val getActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val returnedData = result.data?.getStringExtra("return_data") ?: ""
                Toast.makeText(this, returnedData, Toast.LENGTH_LONG).show()

            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                val returnedData = result.data?.getStringExtra("return_data") ?: ""
                Toast.makeText(this, returnedData, Toast.LENGTH_LONG).show()
            }
    }

}