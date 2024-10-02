package edu.iesam.dam2024.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

        fun ImageView.loadUrl(urlImg: String) {

            Glide
                .with(this)
                .load(urlImg)
                .into(this)
        }