package com.example.expressproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.expressproject.R
import com.example.expressproject.model.CategoriesList
import com.example.expressproject.model.Category

class CategoriesAdapter(var categoriesList: ArrayList<Category>, var context: Context) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById<ImageView>(R.id.categoryIcon)
        var categoryName = itemView.findViewById<TextView>(R.id.tvCategoryName)
        var percentage = itemView.findViewById<TextView>(R.id.tvPercentage)
        var price = itemView.findViewById<TextView>(R.id.tvPrice)

     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         var singleLine = LayoutInflater.from(parent.context).inflate(R.layout.single_line_recycler,parent,false)
         return ViewHolder(singleLine)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.image.setImageResource(categoriesList.get(position).icon)
         holder.categoryName.text = categoriesList.get(position).name
         holder.percentage.text = categoriesList.get(position).amount.toString()
         holder.price.text = categoriesList.get(position).amount.toString()
         holder.image.setColorFilter(ContextCompat.getColor(context, categoriesList.get(position).color))
     }

     override fun getItemCount(): Int {
         return categoriesList.size
     }


 }