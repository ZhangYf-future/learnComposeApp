package com.zyf.learncomposeapp.datasource

import com.zyf.learncomposeapp.R
import com.zyf.learncomposeapp.entity.MessageEntity
import kotlin.random.Random

object MessageDataSource {

    fun createConversation(): List<MessageEntity>{
        val list = mutableListOf<MessageEntity>()
        for(i in 0 .. 100){
            val name = "用户$i"
            val random = Random.nextInt(0,50)
            val builder = StringBuilder()
            for(index in 0 .. random){
                builder.append("这里是消息内容;")
            }
            list.add(MessageEntity(name,builder.toString(),R.drawable.avatar))
        }
        return list
    }
}