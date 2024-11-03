package com.example.assignment_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment_1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fromTextView.text = String.format("From: %s", intent.getStringExtra("sender"))
        binding.toTextView.text = String.format("To: %s", intent.getStringExtra("receiver"))
        binding.messageTextView.text = intent.getStringExtra("message")

        binding.clearButton.setOnClickListener({
            binding.fromTextView.text = ""
            binding.toTextView.text = ""
            binding.messageTextView.text = ""

            Toast.makeText(this, "Cleared successfully", Toast.LENGTH_SHORT).show()
        })

        /*
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
    }
}