package com.example.marchenproject

import android.app.LauncherActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdapterOfFairyTaleLibrary (listArray: ArrayList<ListOfFairyTaleContent>, context:Context) : RecyclerView.Adapter<AdapterOfFairyTaleLibrary.ViewHolder>() {
    var listArrayInRecycler = listArray
    var contextInRecycler = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tv_name_of_fairy_tale)
        val tvCreator = view.findViewById<TextView>(R.id.tv_creator_of_fairy_tale)
        val tvDuration = view.findViewById<TextView>(R.id.tv_duration_of_fairy_tale)
        val tvDescription = view.findViewById<TextView>(R.id.tv_description_of_fairy_tale)
        val imFairyTale = view.findViewById<ImageView>(R.id.im_fairy_tale)

        fun BindContentToContainer(listOfFairyTaleContent: ListOfFairyTaleContent, context: Context){

            tvTitle.text = listOfFairyTaleContent.title_Text.toString()
            tvCreator.text = listOfFairyTaleContent.creator_Text.toString()
            tvDuration.text = listOfFairyTaleContent.duration_Text.toString()
            tvDescription.text = listOfFairyTaleContent.description_Text.toString()
            imFairyTale.setImageResource(listOfFairyTaleContent.image_id)
            itemView.setOnClickListener(){ Toast.makeText(context, "Pressed : ${tvTitle.text}",Toast.LENGTH_SHORT).show()}

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextInRecycler)
        return ViewHolder(inflater.inflate(R.layout.content_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var listOfFairyTaleContent = listArrayInRecycler[position]
             holder.BindContentToContainer(listOfFairyTaleContent,contextInRecycler)
    }

    override fun getItemCount(): Int {
        return  listArrayInRecycler.size
    }
}