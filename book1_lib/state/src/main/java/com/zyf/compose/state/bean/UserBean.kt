package com.zyf.compose.state.bean

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//@Parcelize
data class UserBean(
    val userName: String,
    val age: Int
) {
    override fun toString(): String {
        return "User:{$userName - $age}"
    }
}
