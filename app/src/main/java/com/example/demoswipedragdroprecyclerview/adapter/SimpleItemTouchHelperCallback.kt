package com.example.demoswipedragdroprecyclerview.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.demoswipedragdroprecyclerview.utils.ItemTouchListener

class SimpleItemTouchHelperCallback(private var itemListener: ItemTouchListener) :
    ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        var dragFlag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        var swipeFlag = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(dragFlag, swipeFlag)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        itemListener.onMove(viewHolder.adapterPosition, target.adapterPosition)
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        itemListener.swipe(viewHolder.adapterPosition, direction)
    }
}
