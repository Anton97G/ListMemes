package com.example.listmemes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.listmemes.data.RetrofitService
import com.example.listmemes.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btnShowMemes.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val response = RetrofitService.apiService.getMemes()
                    val listMemes = response.memes
                    val adapter = RecyclerAdapter()
                    binding.rcViewMemes.adapter = adapter
                    adapter.submitList(listMemes
                    )
                } catch (e: Exception) {
                    Log.d("ERROR", e.message.toString())
                }
            }
        }
    }


}