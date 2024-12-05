package com.kyura.myproject1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvPlayer: RecyclerView
    private var list: ArrayList<Player> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val btnBasketballPlayer: Button = findViewById(R.id.btn_basketball_player)
        btnBasketballPlayer.setOnClickListener(this)

        val btnAboutMe: Button = findViewById(R.id.btn_about_me)
        btnAboutMe.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_basketball_player -> {
                val moveIntent = Intent(this@MainActivity, BasketballPlayerActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_about_me -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
    }
}