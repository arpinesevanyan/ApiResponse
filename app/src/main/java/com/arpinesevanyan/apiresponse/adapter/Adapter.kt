package com.arpinesevanyan.apiresponse.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arpinesevanyan.apiresponse.R
import com.arpinesevanyan.apiresponse.data.Entry

class Adapter(private var contentList: List<Entry>) :
    RecyclerView.Adapter<Adapter.ContentViewHolder>() {

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ContentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }
    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val currentItem = contentList[position]

        holder.titleTextView.text = currentItem.API
        holder.descriptionTextView.text = currentItem.Description
        holder.linkButton.text = currentItem.Link
        holder.linkButton.setOnClickListener {
            currentItem.Link.let { url ->
                onItemClickListener?.invoke(url)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setContentList(newList: List<Entry>) {
        contentList = newList
        notifyDataSetChanged()
    }

    inner class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextViewApi)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val linkButton: TextView = itemView.findViewById(R.id.linkButton)
    }

}
