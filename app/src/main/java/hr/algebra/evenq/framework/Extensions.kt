package hr.algebra.evenq.framework

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

fun Context.showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

inline fun <reified T : Activity> Context.startActivity() =
    startActivity(Intent(this, T::class.java).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    })