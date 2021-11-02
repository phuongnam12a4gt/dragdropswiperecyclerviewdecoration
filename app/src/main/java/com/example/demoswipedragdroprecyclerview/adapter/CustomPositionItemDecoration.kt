package com.example.demoswipedragdroprecyclerview.adapter

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView


class CustomPositionItemDecoration(private val dividerDrawable: Drawable) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        rect: Rect,
        view: View,
        parent: RecyclerView,
        s: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
            .let {if (it == RecyclerView.NO_POSITION) return else it }
        rect.bottom =
            if (position % 2 == 0) 2
            else dividerDrawable.intrinsicHeight
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        parent.children
            .forEach { view ->
                val position = parent.getChildAdapterPosition(view)
                    .let { if (it == RecyclerView.NO_POSITION) return else it }
                if (position % 2 != 0) {
//                    val left = view.right
//                    val top = parent.paddingTop
//                    val right = left + dividerDrawable.intrinsicWidth
//                    val bottom = top + dividerDrawable.intrinsicHeight - parent.paddingBottom
                    val top = view.bottom
                    val left = parent.paddingLeft
                    val bottom = top + dividerDrawable.intrinsicHeight
                    val right = left + dividerDrawable.intrinsicWidth+parent.paddingRight
                    dividerDrawable.bounds = Rect(left, top, right, bottom)
                    dividerDrawable.draw(canvas)
                }
            }
    }
}
