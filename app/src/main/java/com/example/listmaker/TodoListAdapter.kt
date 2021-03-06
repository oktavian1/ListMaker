package com.example.listmaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_list_view_holder.view.*

class TodoListAdapter(val lists: ArrayList<TaskList>): RecyclerView.Adapter<TodoListAdapter.ListViewHolder>() {

//    private var todoList = mutableListOf("Android Development", "House Work", "House 46")
//
//    fun addNewItem(listName : String = ""){
//        if (listName.isEmpty()) todoList.add("Todo List " + (todoList.size +1))
//        else todoList.add(listName)
//        notifyDataSetChanged()
//    }

    fun addList(list: TaskList){
        lists.add(list)
        notifyItemInserted(lists.size -1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_list_view_holder, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = lists.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.listPositionTextView.text = (position +1).toString()
        holder.listTitleTextView.text = lists[position].name
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var listPositionTextView = itemView.itemNumber
        var listTitleTextView = itemView.itemString
    }
}