package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie.databinding.ActivityEditActivitiyBinding
import com.example.movie.models.Model
import com.example.movie.utils.MySharedPrefernce

class EditActivitiy : AppCompatActivity() {
    private val binding by lazy { ActivityEditActivitiyBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val position = intent.getIntExtra("modelKey1", 0)
        val list = MySharedPrefernce.list
        val model1 = list[position]
        binding.apply {

            edtName.setText(model1.kinoNomi)
            edtAuthor.setText(model1.aktiyor)
            edtAbout.setText(model1.aboutMovie)

        }
        list.removeAt(position)
        MySharedPrefernce.list = list
        binding.btnSave.setOnClickListener {

            val model = Model(
                binding.edtName.text.toString(),
                aktiyor = binding.edtAuthor.text.toString(),
                aboutMovie = binding.edtAbout.text.toString(),
            )
            list.add(position, model)
            MySharedPrefernce.list = list
            finish()
        }
    }
}