package com.example.instagramactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etname: EditText
    lateinit var etemail: EditText
    lateinit var etphone: EditText
    lateinit var etgender: EditText
    lateinit var etpassword: EditText
    lateinit var btnbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun castviews() {
            etname = findViewById(R.id.etname)
            etgender = findViewById(R.id.etgender)
            etphone = findViewById(R.id.etphone)
            etemail = findViewById(R.id.etemail)
            etpassword = findViewById(R.id.etPassword)
            btnbutton = findViewById(R.id.btnbutton)

        }

        fun ClickNext() {
            btnbutton.setOnClickListener {
                if (etname.text.toString().isEmpty() || (etpassword.text.toString()
                        .isEmpty() || etgender.text.toString().isEmpty() ||
                            etemail.text.toString().isEmpty() || etphone.text.toString().isEmpty())
                ) {
                    etname.setError("YOUR NAME")
                    etpassword.setError("INPUT PASSWORD ")
                    etemail.setError("YOUR EMAIL ")
                    etgender.setError("MAKE A CHOICE ")
                    etphone.setError("NUMBER")
                } else {

                    var name = etname.text.toString()
                    var password = etpassword.text.toString()
                    var phone = etphone.text.toString()
                    var email = etemail.text.toString()
                    var gender = etgender.text.toString()

                    val person = Person(name, gender, password, phone, email)
                    Toast.makeText(baseContext, person.toString(), Toast.LENGTH_LONG).show()
                }
            }
            btnbutton.setOnClickListener {
                var button=Intent(baseContext,LoginActivity::class.java)
                startActivity(button)
            }
        }
    }
}

    data class Person(
        var name: String,
        var gender: String,
        var password: String,
        var phone: String,
        var email: String
    )




