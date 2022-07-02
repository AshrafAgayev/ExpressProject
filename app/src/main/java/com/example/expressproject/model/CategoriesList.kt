package com.example.expressproject.model

import androidx.core.graphics.toColor
import com.example.expressproject.R

class CategoriesList {
    private var categories = ArrayList<Category>()

    fun getCategories(): ArrayList<Category>{
        categories.add(Category("Airlines", 120F, R.drawable.plane,"#4BAFF8", R.color.airlines))
        categories.add(Category("Rent A Car", 200F, R.drawable.car, "#9B2FF5",R.color.rentacar))
        categories.add(Category("Hotels and Motels", 1000F, R.drawable.bed,"#5723E1", R.color.hotels))
        categories.add(Category("Transport", 40.6F, R.drawable.transport, "#C3291C",R.color.transport))
        categories.add(Category("Cars and Vehicles", 12F, R.drawable.car,"#3255F4",R.color.cars))
        categories.add(Category("Personal Services", 124F, R.drawable.personal,"#9D8980", R.color.personal))
        categories.add(Category("Government services", 410F, R.drawable.government,"#50B5D0", R.color.government))
        categories.add(Category("Professional services", 523F, R.drawable.businessman,"#757575",R.color.bussines))
        categories.add(Category("Bussiness Services", 10.5F, R.drawable.bussines, "#212121", R.color.bussines))
        categories.add(Category("Clothing", 120.3F, R.drawable.clothe, "#E1325A", R.color.clothing))


//        categories.add(Category("Airlines", 120F, R.drawable.plane, Color.WHITE))
//        categories.add(Category("Rent A Car", 200F, R.drawable.car, Color.BLACK))
//        categories.add(Category("Hotels and Motels", 1000F, R.drawable.bed,Color.GREEN))
//        categories.add(Category("Transport", 40.6F, R.drawable.transport, Color.CYAN))
//        categories.add(Category("Cars and Vehicles", 12F, R.drawable.car,Color.RED))
//        categories.add(Category("Personal Services", 124F, R.drawable.personal,Color.YELLOW))
//        categories.add(Category("Government services", 410F, R.drawable.government,Color.RED))
//        categories.add(Category("Professional services", 523F, R.drawable.businessman,Color.YELLOW))
//        categories.add(Category("Bussiness Services", 10.5F, R.drawable.bussines,Color.GREEN))
//        categories.add(Category("Clothing", 120.3F, R.drawable.clothe,Color.BLACK))

        return categories

    }
}