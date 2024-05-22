package com.example.superherobook

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TanitimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tanitim)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var textView = findViewById<TextView>(R.id.textView)
        var imageView = findViewById<ImageView>(R.id.imageView)
        val intent = intent
       textView.text =  intent.getStringExtra("superHeroName")
        val selectedHeroImage = intent.getIntExtra("superHeroImage",0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, selectedHeroImage)
        imageView.setImageBitmap(bitmap)
        /*val selectedHero = SingletonClass.SelectedHero
        val selectedImage = SingletonClass.gorsel
        imageView.setImageBitmap(selectedImage)*/
    }
}