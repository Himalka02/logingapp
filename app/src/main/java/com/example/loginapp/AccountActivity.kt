package com.example.loginapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val username = intent.getStringExtra("USERNAME")
        val welcome_messageTextView = findViewById<TextView>(R.id.welcome_message)
        val enter_nameEditText = findViewById<EditText>(R.id.enter_name)
        val enter_nicEditText = findViewById<EditText>(R.id.enter_nic)
        val enter_dobEditText = findViewById<EditText>(R.id.enter_dob)
        val enter_genderEditText = findViewById<EditText>(R.id.enter_gender)
        val enter_mobileEditText = findViewById<EditText>(R.id.enter_mobile)
        val enter_emailEditText = findViewById<EditText>(R.id.enter_email)
        val preview_buttonButton = findViewById<Button>(R.id.preview_button)

        welcome_messageTextView.text = "Hi $username, this is your account."

        preview_buttonButton.setOnClickListener {
            val name = enter_nameEditText.text.toString()
            val nic = enter_nicEditText.text.toString()
            val dob = enter_dobEditText.text.toString()
            val gender = enter_genderEditText.text.toString()
            val mobile = enter_mobileEditText.text.toString()
            val email = enter_emailEditText.text.toString()

            if (name.isNotEmpty() && nic.isNotEmpty() && dob.isNotEmpty() && gender.isNotEmpty() && mobile.isNotEmpty() && email.isNotEmpty()) {
                val previewMessage = """
                    name: $name
                    NIC: $nic
                    DOB: $dob
                    Gender: $gender
                    Mobile: $mobile
                    Email: $email
                """.trimIndent()

                Toast.makeText(this, previewMessage, Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}