package com.example.ioc

/**
 * description:
 * Created by dailei on 2021/1/13
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewInject(val value: Int)