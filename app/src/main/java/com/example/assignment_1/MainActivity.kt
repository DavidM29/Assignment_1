package com.example.assignment_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.sendMessageButton.setOnClickListener({
            val yourEmail = binding.yourEmailEditText.text.toString()
            val recipientEmail = binding.recipientEmailEditText.text.toString()
            val message = binding.messageEditText.text.toString()

            if (yourEmail.isEmpty() || recipientEmail.isEmpty() || message.isEmpty())
            {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            }
            else if (!yourEmail.contains("@") || !recipientEmail.contains("@"))
            {
                Toast.makeText(this, "Please enter valid e-mails.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val newIntent = Intent(this, MainActivity2::class.java).apply {
                    putExtra("sender", yourEmail)
                    putExtra("receiver", recipientEmail)
                    putExtra("message", message)
                }

                startActivity(newIntent)
            }
        })

        /*
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
    }
}