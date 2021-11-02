package com.example.demoswipedragdroprecyclerview

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoswipedragdroprecyclerview.adapter.CustomPositionItemDecoration
import com.example.demoswipedragdroprecyclerview.adapter.RecyclerViewUser
import com.example.demoswipedragdroprecyclerview.adapter.SimpleItemTouchHelperCallback
import com.example.demoswipedragdroprecyclerview.model.User
import com.example.demoswipedragdroprecyclerview.utils.ItemTouchListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: RecyclerViewUser = RecyclerViewUser(
        mutableListOf(
            User("TUAN", "22"),
            User("VU", "22"),
            User("NAM", "22"),
            User("KHAI", "22"),
            User("HIEN", "22"),
            User("HAU", "22")
        )
    )

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewUser.adapter = adapter
        recyclerViewUser.layoutManager = LinearLayoutManager(this)
        val calback = SimpleItemTouchHelperCallback(object : ItemTouchListener {
            override fun onMove(oldPosition: Int, newOldPosition: Int) {
                adapter.onMove(oldPosition, newOldPosition)
            }

            override fun swipe(position: Int, direction: Int) {
                adapter.swipe(position, direction)
            }

        })
        var itemTouchHelperOne = ItemTouchHelper(calback)
        itemTouchHelperOne.attachToRecyclerView(recyclerViewUser)
//        recyclerViewUser.addItemDecoration(VerticalSpaceItemDecoration(48))
        applicationContext.getDrawable(R.drawable.spliter)?.let {
            CustomPositionItemDecoration(
                it
            )
        }?.let { recyclerViewUser.addItemDecoration(it) }
    }
}
