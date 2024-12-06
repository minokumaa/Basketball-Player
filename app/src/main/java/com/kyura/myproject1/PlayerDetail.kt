package com.kyura.myproject1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PlayerDetail : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_POSITION = "extra_position"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_detail_player)

        supportActionBar?.hide()

        val tvSetName: TextView = findViewById(R.id.tv_set_player)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvPosition: TextView = findViewById(R.id.tv_set_position)
        val tvSetDetail: TextView = findViewById(R.id.tv_set_detail)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tPhoto = intent.getStringExtra(EXTRA_PHOTO)
        val tPosition= intent.getStringExtra(EXTRA_POSITION)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)



        tvSetName.text = tName
        Glide.with(this)
            .load(tPhoto)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvPosition.text = tPosition
        tvSetDetail.text = tDetail


        val btnShare: Button = findViewById(R.id.action_share)
        btnShare.setOnClickListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.action_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, EXTRA_DETAIL)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }
}