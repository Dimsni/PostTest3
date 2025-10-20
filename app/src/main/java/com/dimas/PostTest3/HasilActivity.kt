package com.dimas.PostTest3

// HasilActivity.kt
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimas.PostTest3.MainActivity.Companion.DATA_AGE
import com.dimas.PostTest3.MainActivity.Companion.DATA_EMAIL
import com.dimas.PostTest3.MainActivity.Companion.DATA_FULL_NAME
import com.dimas.PostTest3.MainActivity.Companion.DATA_GENDER
import com.dimas.PostTest3.MainActivity.Companion.DATA_USERNAME
import com.dimas.PostTest3.databinding.ActivityHasilBinding

class HasilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHasilBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val fullName = intent.getStringExtra(DATA_FULL_NAME)
        val username = intent.getStringExtra(DATA_USERNAME)
        val age = intent.getStringExtra(DATA_AGE)
        val email = intent.getStringExtra(DATA_EMAIL)
        val gender = intent.getStringExtra(DATA_GENDER)

        // Tampilkan data ke TextView yang sesuai
        binding.apply {
            tvFullNameResult.text = "Full Name: $fullName"
            tvUsernameResult.text = "Username: $username"
            tvAgeResult.text = "Age: $age"
            tvEmailResult.text = "Email: $email"
            tvGenderResult.text = "Gender: $gender"

            // Tambahkan sedikit efek menarik berdasarkan gender
            if (gender == "Laki-laki") {
                tvGenderResult.setTextColor(Color.BLUE)
            } else {
                tvGenderResult.setTextColor(Color.MAGENTA)
            }
        }
    }
}