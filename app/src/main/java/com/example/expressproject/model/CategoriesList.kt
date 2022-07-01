package com.example.expressproject.model

import android.graphics.Color
import android.widget.ArrayAdapter
import com.example.expressproject.R

class CategoriesList {
    private var categories = ArrayList<Category>()

    fun getCategories(): ArrayList<Category>{
        categories.add(Category("Airlines", 120F, R.drawable.plane, R.color.airlines))
        categories.add(Category("Rent A Car", 200F, R.drawable.car, R.color.rentacar))
        categories.add(Category("Hotels and Motels", 1000F, R.drawable.bed,R.color.hotels))
        categories.add(Category("Transport", 40.6F, R.drawable.transport, R.color.transport))
        categories.add(Category("Cars and Vehicles", 12F, R.drawable.car,R.color.cars))
        categories.add(Category("Personal Services", 124F, R.drawable.personal,R.color.personal))
        categories.add(Category("Government services", 410F, R.drawable.government,R.color.government))
        categories.add(Category("Professional services", 523F, R.drawable.businessman,R.color.professional))
        categories.add(Category("Bussiness Services", 10.5F, R.drawable.bussines,R.color.bussines))
        categories.add(Category("Clothing", 120.3F, R.drawable.clothe, R.color.clothing))

        return categories

    }
}