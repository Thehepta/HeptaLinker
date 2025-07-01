package com.example.heptalinker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.heptalinker.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    companion object {
        // Used to load the 'linker' library on application startup.
        init {
            System.loadLibrary("linker")
        }
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
    }
    external fun  stringFromJNI() : String;
}