package com.example.expressproject


import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expressproject.adapters.CategoriesAdapter
import com.example.expressproject.model.CategoriesList
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var categoriesRecycler = findViewById<RecyclerView>(R.id.categoriesRecycler)
        var pieChart: PieChart = findViewById(R.id.pieChart)

        setSpinnerData()


        setupPieChart()

        var layoutManager = LinearLayoutManager(this)


        var categories = CategoriesList().getCategories()
        categoriesRecycler.layoutManager = layoutManager
        categoriesRecycler.adapter = CategoriesAdapter(categories, this)

    }

    private fun setSpinnerData() {


        val Months = arrayOf(
            "Yanvar", "Fevral", "Mart", "Aprel", "May", "Iyun", "Iyul", "Avqust", "Sentyabr",
            "Oktyabr", "Noyabr", "Dekabr"
        )

        var spinnerYear = findViewById<Spinner>(R.id.spinner_year)
        var spinnerMonth = findViewById<Spinner>(R.id.spinner_month)

        //Years
        val yearsList = ArrayList<String>()
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)

        for (i in 1980..currentYear) {
            yearsList.add(i.toString())
        }
        val adapterYears = ArrayAdapter<String>(
            this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            yearsList
        )
        spinnerYear.adapter = adapterYears

        //Months
        val adapterMonths = ArrayAdapter<String>(
            this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            Months
        )

        spinnerMonth.adapter = adapterMonths
    }


    fun setupPieChart() {
        var pieChart: PieChart = findViewById(R.id.pieChart)

        var categoriesList = CategoriesList().getCategories()
        var pieList = ArrayList<PieEntry>()

        for (i in categoriesList) {
            pieList.add(PieEntry(i.amount, i.name, i.icon))
        }

        var dataset = PieDataSet(pieList, null)

        var colors = ArrayList<Int>()


        for (i in categoriesList) {
            colors.add(i.color)
        }

//
//        colors.add(R.color.purple_200)
//        colors.add(R.color.teal_200)
//        colors.add(R.color.purple_200)
//        colors.add(R.color.teal_200)
//        colors.add(R.color.purple_200)
//        colors.add(R.color.teal_200)
//        colors.add(R.color.purple_200)
//        colors.add(R.color.teal_200)
//        colors.add(R.color.purple_200)
//        colors.add(R.color.teal_200)

        var pieData = PieData(dataset)



        pieData.setValueTextSize(16F)
        dataset.colors = colors
        pieData.setValueTextColor(R.color.white)
        pieData.setValueFormatter(PercentFormatter())
        pieChart.setUsePercentValues(true)
        pieChart.setData(pieData)
        pieChart.animateY(1000)
        pieChart.invalidate()
        pieChart.holeRadius = 80F


    }


}