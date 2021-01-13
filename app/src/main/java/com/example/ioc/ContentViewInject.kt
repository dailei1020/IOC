package com.example.ioc

import android.content.Context

/**
 * description:
 * Created by dailei on 2021/1/13
 */
object ContentViewInject {
    fun bind(context: Context) {
        injectLayout(context)
        injectView(context)
    }

    private fun injectView(context: Context) {
        val aClass: Class<Context> = context.javaClass
        try {
            val findViewById = aClass.getMethod("findViewById", Int::class.javaPrimitiveType)
            val declaredFields = aClass.declaredFields
            for (declaredField in declaredFields) {
                val annotation: ViewInject? = declaredField.getAnnotation(ViewInject::class.java)
                    ?: continue
                val id = annotation?.value
                val view = findViewById.invoke(context, id)
                declaredField.isAccessible = true
                declaredField.set(context, view)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun injectLayout(context: Context) {
        val aClass: Class<out Context> = context.javaClass
        try {
            val setContentViewMethod =
                aClass.getMethod("setContentView", Int::class.javaPrimitiveType)
            val annotation =
                aClass.getAnnotation(ContentView::class.java) ?: return
            val layoutId = annotation.value
            setContentViewMethod.invoke(context, layoutId)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}