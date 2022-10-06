package com.example.test

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test.databinding.ActivityMainBinding
import com.example.test.databinding.ActivityReadBinding
import com.example.test.model.Model
import com.example.test.model.PostModel
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class ReadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = intent.getParcelableExtra<Model>("list")
        if (model != null){
         binding.apply {
             titleActivity.text = model.title
             description.text = model.description
             image.setImageResource(model.image)
             descriptiont.text = model.descriptiontext
         }
        }
        binding.folover.setOnClickListener {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .build()
        val jsonPlaceholderApi=retrofitBuilder.create(JsonPlaceholderApi::class.java)

        val post= PostModel(1,1,"title", "this is the body")
       val call=  jsonPlaceholderApi.sendModel(post)
        call.enqueue(object  : Callback<PostModel>{
            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                Toast.makeText(this@ReadActivity,"${response.code().toString()}",Toast.LENGTH_SHORT).show()
                response.code()
            }
            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                Toast.makeText(this@ReadActivity, t.message.toString(),Toast.LENGTH_SHORT).show()
            }

        })
    }
    }
}