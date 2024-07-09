package com.zyf.learncomposeapp.entity

import com.zyf.learncomposeapp.R

data class UserEntity(
    val userHeadImageId: Int,
    val userNickName: String
){
    companion object{
        fun createUserCanada() = UserEntity(R.drawable.fj3,"Canada")
        fun createUserDavid() = UserEntity(R.drawable.png1,"David")
        fun createUserFrank() = UserEntity(R.drawable.png2,"Frank")
        fun createUserGalance() = UserEntity(R.drawable.png4,"张三")
        fun createUserHebe() = UserEntity(R.drawable.png5,"Hebe")
        fun createUserIvy() = UserEntity(R.drawable.png6,"李四")
        fun createUserJack() = UserEntity(R.drawable.png7,"Jack")
        fun createUserKeven() = UserEntity(R.drawable.png8,"王二麻子")
    }
}
