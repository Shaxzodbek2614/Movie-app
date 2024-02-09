package com.example.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.movie.adapter.ModelAdapter
import com.example.movie.databinding.ActivityMainBinding
import com.example.movie.databinding.ItemRvBinding
import com.example.movie.models.Model
import com.example.movie.utils.MySharedPrefernce


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var modelAdapter: ModelAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this,addActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        MySharedPrefernce.init(this)
        val list = MySharedPrefernce.list

        modelAdapter = ModelAdapter(object :ModelAdapter.RvAction{
            override fun myItemClick(model: Model,position: Int) {
                val intent = Intent(this@MainActivity,InfoActivity::class.java)
                intent.putExtra("modelKey",model)
                startActivity(intent)
            }

            override fun itemView(position: Int) {
                list.removeAt(position)
                modelAdapter.notifyItemRemoved(position)
                MySharedPrefernce.list = list
            }

            override fun itemEdit(model: Model, position: Int) {
                val intent = Intent(this@MainActivity,EditActivitiy::class.java)
                intent.putExtra("modelKey1",position)
                startActivity(intent)
            }
        },this,list)
        binding.rv.adapter = modelAdapter

    }

}