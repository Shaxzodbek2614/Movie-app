package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie.databinding.ActivityInfoBinding
import com.example.movie.models.Model

class InfoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityInfoBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list = arrayOf("alasas")

        val model = intent.getSerializableExtra("modelKey") as Model
        binding.apply {
            info.text = model.kinoNomi
            infoName.text = "${list[0]}: ${model.kinoNomi}"
            infoAuthors.text = "Movie authors: ${model.aktiyor}"
            infoDate.text = "Date: ${model.date}"
            infoAbout.text = "About movie: ${model.aboutMovie}"

            btnClose.setOnClickListener {
                finish()
            }
        }
    }
}