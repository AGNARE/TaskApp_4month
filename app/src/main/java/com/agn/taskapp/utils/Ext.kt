package com.agn.taskapp.utils

import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.agn.taskapp.R
import com.bumptech.glide.Glide

// extension расширение классов

fun Fragment.showToast(msg: String) {
    Toast.makeText(requireContext(),msg, Toast.LENGTH_SHORT).show()
}


fun ImageView.loadImage(url: String?){
    Glide.with(this).load(url).placeholder(R.drawable.ic_person_add).into(this)
}