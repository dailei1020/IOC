package com.example.ioc

/**
 * description:
 * Created by dailei on 2021/1/13
 */
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ContentView(val value: Int)