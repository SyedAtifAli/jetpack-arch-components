package com.example.architecturecomponents.dataBindingexample

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
/*
binding adapter
using extension function
making a new attribute in ImageView class that loads data from url using glide
 */
@BindingAdapter("imagefromurl")
fun ImageView.imagefromurl(url: String){
    Glide.with(this.context).load(url).into(this)

}