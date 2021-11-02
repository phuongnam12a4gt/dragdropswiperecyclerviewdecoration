package com.example.demoswipedragdroprecyclerview.utils

interface ItemTouchListener {
    fun onMove(oldPosition:Int,newOldPosition:Int)
    fun swipe(position:Int,direction:Int)
}
