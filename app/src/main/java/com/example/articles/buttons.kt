package com.example.articles


import android.view.LayoutInflater
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

class buttons {
    lateinit var binding : ActivityMainBinding

    fun onClick(view : View) {

        when(view.getId()){
            R.id.BTNauth -> {
            }
            R.id.BTNreg -> {

            }
            }
        }
    }