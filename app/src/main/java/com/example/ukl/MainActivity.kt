package com.example.ukl

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.editTextId)
        edtPassword = findViewById(R.id.editTextTextPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        var emptyEmail: Boolean = false
        var emptyPassword: Boolean = false

        if(edtEmail.text.toString().trim().length == 0){
            edtEmail.error = "Email tidak boleh kosong"
            emptyEmail = true
        }

        if(edtPassword.text.toString().trim().length == 0){
            edtPassword.error = "Password tidak boleh kosong"
            emptyPassword = true
        }

        if(!emptyEmail && !emptyPassword){
            val dataReceived = Intent(this@MainActivity, page2::class.java)
            val email = edtEmail.text.toString()
            dataReceived.putExtra("String", email)
            startActivity(dataReceived)
        }
    }
}