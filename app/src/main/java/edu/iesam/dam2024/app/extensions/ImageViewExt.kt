package edu.iesam.dam2024.app.extensions

import android.widget.ImageView
import coil.load
import com.bumptech.glide.Glide


        /*
        Esto con glide
        fun ImageView.loadUrl(url: String) {
            Glide
                .with(this)
                .load(url)
                .into(this)
        }
         */

fun ImageView.loadUrl(url: String) {
    this.load(url)
}