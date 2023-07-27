package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text:TextView = findViewById(R.id.json_text)
        val service = retrofit.create(QiitaService::class.java)
        val get = service.fetchData()
        GlobalScope.launch(Dispatchers.IO) {
            var responseBody = get.execute()
            var weatherApiResponse = responseBody.body()?: throw IllegalStateException("bodyがnullだよ！")
            runBlocking {
                launch(Dispatchers.Main) {
                    text.setText(weatherApiResponse.toString())
                }
            }
        }
    }
}