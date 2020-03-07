package com.taghavi.materialmotiontest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var demos: Array<Demo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        demos = arrayOf(
            Demo("Tossable Tap", Intent(this, TossableTapActivity::class.java)),
            Demo("Tween", Intent(this, TweenActivity::class.java)),
            Demo("Gesture", Intent(this, GestureActivity::class.java))
        )

        val recyclerView: RecyclerView = findViewById(R.id.list)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DemoAdapter()
    }

    private class Demo(var text: String, var intent: Intent)

    private class DemoAdapter : RecyclerView.Adapter<DemoViewHolder?>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
            return DemoViewHolder(parent, getLayoutInflater())
        }

        override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
            val demo: Demo = this.demos.get(position)
            holder.text.text = demo.text
            holder.itemView.setOnClickListener { startActivity(demo.intent) }
        }

        override fun getItemCount(): Int {
            return demos.size
        }
    }

    private class DemoViewHolder(parent: ViewGroup, inflater: LayoutInflater) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.demo_view, parent, false)) {
        val text: TextView = itemView.findViewById(R.id.text)
    }
}
