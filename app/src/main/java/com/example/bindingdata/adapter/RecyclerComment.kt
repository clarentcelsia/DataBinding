package com.example.bindingdata.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bindingdata.R

class RecyclerComment(
    private var list: ArrayList<String>
) : RecyclerView.Adapter<RecyclerComment.CommentViewHolder>(){

    class CommentViewHolder(private val view : View): RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.tvCommentItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
        return CommentViewHolder(inflate)
    }
    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        //get data
        val data = list[position]
        holder.textView.text = data

    }

    override fun getItemCount(): Int = list.size


}