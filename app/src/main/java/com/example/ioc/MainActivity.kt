package com.example.ioc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@ContentView(R.layout.activity_main)
class MainActivity : AppCompatActivity() {

    @ViewInject(R.id.button)
    private var button: Button? = null

    @ViewInject(R.id.textView)
    private var textView:TextView? = null

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ContentViewInject.bind(this)
        button?.text = "button 注入成功"
        textView?.text = "text 注入成功"
    }
}