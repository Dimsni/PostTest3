package com.dimas.PostTest3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dimas.PostTest3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            // Ambil semua data dari input
            val fullName = binding.etFullName.text.toString()
            val username = binding.etUsername.text.toString()
            val age = binding.etAge.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()
            val gender = if (binding.rbLakiLaki.isChecked) "Laki-laki" else "Perempuan"

            // Validasi: Pastikan tidak ada yang kosong
            if (fullName.isEmpty() || username.isEmpty() || age.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua kolom wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi: Pastikan password cocok
            if (password != confirmPassword) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Jika semua validasi lolos, kirim data ke HasilActivity
            val intent = Intent(this, HasilActivity::class.java).apply {
                putExtra(DATA_FULL_NAME, fullName)
                putExtra(DATA_USERNAME, username)
                putExtra(DATA_AGE, age)
                putExtra(DATA_EMAIL, email)
                putExtra(DATA_GENDER, gender)
            }
            startActivity(intent)
        }
    }

    // Definisikan 'key' untuk data yang akan dikirim
    companion object {
        const val DATA_FULL_NAME = "data_full_name"
        const val DATA_USERNAME = "data_username"
        const val DATA_AGE = "data_age"
        const val DATA_EMAIL = "data_email"
        const val DATA_GENDER = "data_gender"
    }
}