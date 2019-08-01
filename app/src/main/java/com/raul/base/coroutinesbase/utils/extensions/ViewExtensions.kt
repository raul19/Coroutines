package com.raul.base.coroutinesbase.utils.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.StringRes
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.raul.base.coroutinesbase.R

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.showSnackBar(message: String, length: Int = Snackbar.LENGTH_LONG, func: Snackbar.() -> Unit = {}) {
    val snack = Snackbar.make(this, message, length)
    snack.func()
    snack.show()
}

fun Snackbar.action(message: String, listener: (View) -> Unit) {
    this.setAction(message, listener)
}

infix fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ImageView.loadUrl(url: String?, placeholder: Int = R.mipmap.ic_launcher) {
    if (url != null) {
        Glide.with(context).load(url).into(this)
    } else {
        // TODO cambiar por el placeholder de la app
        Glide.with(context).load(placeholder).into(this)
    }
}

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, this.getString(resId), duration).show()
}
