package com.example.articles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.articles.authorization.MainApi
import com.example.articles.databinding.ActivityMainBinding
import com.example.articles.user.AuthRequest
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clickListener = buttons()
        binding.BTNauth.setOnClickListener(clickListener::onClick)

      val interceptor = HttpLoggingInterceptor()
      interceptor.level = HttpLoggingInterceptor.Level.BODY

      val client = OkHttpClient.Builder().
      addInterceptor(interceptor).
      build()

      val retrofit =  Retrofit.Builder().
      baseUrl("https://dummyjson.com").client(client).
      addConverterFactory(GsonConverterFactory.create()).build()
      val mainApi = retrofit.create(MainApi::class.java)

      binding.BTNauth.setOnClickListener {
          if(binding.authLogin.text.isNotEmpty() or (binding.authPassword.text.isNotEmpty())) {
              CoroutineScope(Dispatchers.IO).launch {
                  val user = mainApi.auth(
                      AuthRequest(
                          binding.authLogin.text.toString(),
                          binding.authPassword.text.toString()
                      )
                  )
                  runOnUiThread {
                      binding.apply {
                          Picasso.get().load(user.image).into(binding.imageView2)
                          firstname.text = user.firstName
                          lastname.text = user.lastName
                      }
                  }
              }
          }
          else binding.firstname.text = resources.getString(R.string.Enter)
      }

        binding.BTNreg.setOnClickListener {
            val intent = Intent(this, registration::class.java)
            startActivity(intent)
        }




    }


}


