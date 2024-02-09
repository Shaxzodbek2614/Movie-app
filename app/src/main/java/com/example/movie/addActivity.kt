package com.example.movie

import android.graphics.Color
import android.graphics.Color.BLUE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.movie.databinding.ActivityAddBinding
import com.example.movie.models.Model
import com.example.movie.utils.MySharedPrefernce

class addActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        MySharedPrefernce.init(this)
        val list = MySharedPrefernce.list

        binding.apply {

                btnSave.setOnClickListener {

                    val model = Model(
                        edtName.text.toString(),
                        aktiyor = edtAuthor.text.toString(),
                        aboutMovie = edtAbout.text.toString()
                    )
                    if (edtName.text.isEmpty()){
                        edtName.setBackgroundResource(R.drawable.edt_fon2)
                        Toast.makeText(this@addActivity, "1-bo'lim bo'sh", Toast.LENGTH_SHORT).show()
                    }else if (edtAuthor.text.isEmpty()){
                        edtAuthor.setBackgroundResource(R.drawable.edt_fon2)
                        Toast.makeText(this@addActivity, "2-bo'lim bo'sh", Toast.LENGTH_SHORT).show()
                    }
                    if (edtName.text.isNotEmpty() && edtAuthor.text.isNotEmpty()) {
                        list.add(model)
                        MySharedPrefernce.list = list
                        Toast.makeText(this@addActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }

            }
        }

}