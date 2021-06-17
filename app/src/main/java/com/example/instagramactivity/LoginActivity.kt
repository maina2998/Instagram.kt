package com.example.instagramactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        fun castviews() {
            etEmail = findViewById(R.id.etemail)
            etPassword = findViewById(R.id.etPassword)
            btnbutton = findViewById(R.id.btnbutton)

        }

        fun ClickNext() {
            btnbutton.setOnClickListener {
                if ((etPassword.text.toString().isEmpty() ||
                            etEmail.text.toString().isEmpty())
                ) {
                    etPassword.setError("INPUT PASSWORD ")
                    etEmail.setError("YOUR EMAIL ")
                } else {
                    var password = etPassword.text.toString()
                    var email = etEmail.text.toString()
                    val login = Login(password, email)
                    Toast.makeText(baseContext, login.toString(), Toast.LENGTH_LONG).show()
                }
            }
            btnbutton.setOnClickListener {
                var button = Intent(baseContext, LoginActivity::class.java)
                startActivity(button)
            }
        }
    }
}
data class Login(
    var password: String,
    var email: String
)