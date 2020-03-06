package com.taghavi.materialmotiontest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private class Demo(var text: String, var intent: Intent)

    private class DemoViewHolder(parent: ViewGroup, inflater: LayoutInflater): RecyclerView.ViewHolder(inflater.inflate(R.layout.demo_view, parent, false)) {
        private val text: TextView = itemView.findViewById(R.id.text)
    }
}
