package com.example.pesawatkomersil.plane

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pesawatkomersil.R

class PlaneDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_detail_plane)

        val actionbar = supportActionBar
        actionbar?.apply {
            title = "Detail Plane"
            setDisplayHomeAsUpEnabled(true)
        }

        val tvSetName: TextView = findViewById(R.id.tv_set_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvDescription: TextView = findViewById(R.id.tv_set_description)

        // Retrieve the Plane object
        @Suppress("DEPRECATION")
        val plane = intent.getParcelableExtra<Plane>("EXTRA_PLANE")

        // Populate the views with the Plane data
        plane?.let {
            tvSetName.text = it.name
            tvDescription.text = it.description
            imgSetPhoto.setImageResource(it.photo)
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onSupportNavigateUp(): Boolean {
        @Suppress("DEPRECATION")
        onBackPressed()
        return true
    }
}