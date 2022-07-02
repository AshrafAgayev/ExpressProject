package com.example.expressproject.ui

import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.expressproject.R
import com.example.expressproject.model.CategoriesList
import com.example.expressproject.model.Category
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.math.exp

class BottomSheet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_bottom_details)

        var categories = CategoriesList().getCategories()

        var position = intent.getIntExtra("pos", 0)

        var name = findViewById<TextView>(R.id.tvDetailsCategoryName)
        var expense = findViewById<TextView>(R.id.tvDetailsExpense)
        var icon = findViewById<ImageView>(R.id.imgDetailsIcon)


        name.text = categories.get(position).name
        expense.text = categories.get(position).amount.toString()
        icon.setImageResource(categories.get(position).icon)
        icon.setColorFilter(Color.parseColor(categories.get(position).rgb))

    }
}