package com.example.expressproject


import android.graphics.Color
import android.graphics.ColorSpace
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expressproject.adapters.CategoriesAdapter
import com.example.expressproject.model.CategoriesList
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter
import com.github.mikephil.charting.formatter.DefaultValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.renderer.PieChartRenderer
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.eazegraph.lib.models.PieModel
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var toolbar: androidx.appcompat.widget.Toolbar? = findViewById(R.id.toolbar)



        setSupportActionBar(toolbar)
        supportActionBar?.title = null


//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )




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
        var spinnerCards = findViewById<Spinner>(R.id.spinner_card)


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

//    fun piechart3() {
//
//        var chart = findViewById<org.eazegraph.lib.charts.PieChart>(R.id.piechart2)
//
//
//        var categories = CategoriesList().getCategories()
//
//        for (i in categories) {
//            chart.addPieSlice(PieModel(i.name, i.amount, Color.parseColor(i.rgb)))
//
//        }
//
//        chart.isClickable = true
//
//        chart.isUseCustomInnerValue = false
//        chart.currentItem = 0
//
//    }


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

            colors.add(Color.parseColor(i.rgb))

        }


        var pieData = PieData(dataset)

//        for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)

        dataset.setColors(colors)


        pieData.setValueFormatter( IndexAxisValueFormatter())

        pieChart.setData(pieData)
        pieChart.animateY(1000)
        pieChart.setDrawEntryLabels(false)
        pieChart.setUsePercentValues(false)
        pieChart.holeRadius = 70F
        pieChart.description = null


    }



}
