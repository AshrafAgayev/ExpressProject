package com.example.expressproject.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.view.menu.MenuView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.expressproject.MainActivity
import com.example.expressproject.R
import com.example.expressproject.model.CategoriesList
import com.example.expressproject.model.Category
import com.example.expressproject.ui.BottomSheet
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.contracts.contract

class CategoriesAdapter(var categoriesList: ArrayList<Category>, private var context: Context) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setData(holder: CategoriesAdapter.ViewHolder, position: Int) {

            holder.itemView.setOnClickListener {

                var intent = Intent(itemView.context, BottomSheet::class.java)

                itemView.context.startActivity(intent)

            }
        }

        var line = itemView
        var image = itemView.findViewById<ImageView>(R.id.categoryIcon)
        var categoryName = itemView.findViewById<TextView>(R.id.tvCategoryName)
        var percentage = itemView.findViewById<TextView>(R.id.tvPercentage)
        var price = itemView.findViewById<TextView>(R.id.tvPrice)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var singleLine = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_line_recycler, parent, false)

        return ViewHolder(singleLine)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(categoriesList.get(position).icon)
        holder.categoryName.text = categoriesList.get(position).name
        holder.percentage.text = categoriesList.get(position).amount.toString()
        holder.price.text = categoriesList.get(position).amount.toString()



        holder.image.setColorFilter(
            ContextCompat.getColor(
                context,
                categoriesList.get(position).color
            )
        )

        holder.setData(holder, position)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }


}