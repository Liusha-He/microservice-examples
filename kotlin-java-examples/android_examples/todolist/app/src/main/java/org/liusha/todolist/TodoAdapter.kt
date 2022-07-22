package org.liusha.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.service.autofill.TextValueSanitizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter(private val items: MutableList<Todo>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()
{
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    fun addItem(item: Todo) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun deleteDoneItems() {
        items.removeAll { item -> item.isChecked }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curItem = items[position]
        holder.itemView.apply {
            tvTodoTitle.text = curItem.title
            cbDone.isChecked = curItem.isChecked
            toggleStrikeThrough(tvTodoTitle, curItem.isChecked)
            cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvTodoTitle, isChecked)
                curItem.isChecked = !curItem.isChecked
            }
        }
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if (isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}