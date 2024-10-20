package com.mati_tech.kotlinrecyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var datalist: ArrayList<DataClass>
    private lateinit var imagelist: Array<Int>
    private lateinit var titlelist: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagelist = arrayOf(
            R.drawable.android,
            R.drawable.apps,
            R.drawable.chat,
            R.drawable.home,
            R.drawable.jigsaw,
            R.drawable.application,
            R.drawable.robot,
            R.drawable.social
        )

        titlelist = arrayOf(
            "android",
            "apps",
            "chat",
            "home",
            "jigsaw",
            "application",
            "robot",
            "social"
        )

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        datalist = arrayListOf<DataClass>()
        getData() // Ensure this function is call

        // ed to populate data
        recyclerView.adapter = AdapterClass(datalist) { selectedItem ->
            Toast.makeText(this, "i am clicked ${selectedItem.dataTitle}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("ITEM_TITLE", selectedItem.dataTitle)
            startActivity(intent)
        }

    }

    private fun getData() {
        for (i in imagelist.indices) {
            val dataClass = DataClass(imagelist[i], titlelist[i])
            datalist.add(dataClass)
        }
//        recyclerView.adapter = AdapterClass(datalist)
    }
}
