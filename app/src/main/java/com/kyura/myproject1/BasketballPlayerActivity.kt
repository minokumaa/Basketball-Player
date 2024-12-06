package com.kyura.myproject1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BasketballPlayerActivity : AppCompatActivity() {
    private lateinit var rvPlayer: RecyclerView
    private var list: ArrayList<Player> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_basketball_player)

        supportActionBar?.hide()

        rvPlayer = findViewById(R.id.rv_players)
        rvPlayer.setHasFixedSize(true)

        list.addAll(PlayerData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPlayer.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(list)
        rvPlayer.adapter = listPlayerAdapter
    }
}