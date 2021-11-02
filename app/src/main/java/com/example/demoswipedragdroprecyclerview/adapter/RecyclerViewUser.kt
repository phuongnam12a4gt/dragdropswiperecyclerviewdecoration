package com.example.demoswipedragdroprecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoswipedragdroprecyclerview.R
import com.example.demoswipedragdroprecyclerview.model.User
import java.util.*

class RecyclerViewUser(private var list: MutableList<User>) :
    RecyclerView.Adapter<RecyclerViewUser.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(user: User) {
            itemView.findViewById<TextView>(R.id.textViewName).setText(user.name)
            itemView.findViewById<TextView>(R.id.textViewAge).setText(user.age)
        }
    }

    fun onMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(list, i, i + 1);
            }
        } else {
            for (i in fromPosition downTo toPosition + 1 step 1) {
                Collections.swap(list, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    fun swipe(position: Int, direction: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }
}
