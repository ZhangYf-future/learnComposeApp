package com.zyf.learncomposeapp.entity

/**
 * 页面路由相关的数据类
 */
data class RouteEntity<T>(
    val name: String,
    val clazz: Class<T>
)
