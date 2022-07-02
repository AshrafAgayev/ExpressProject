package com.example.expressproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.expressproject.R
import com.example.expressproject.model.CardsDataClass

class CardsAdapter(var context: Context, var data:ArrayList<CardsDataClass>) : BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any? {
    return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var rootView = LayoutInflater.from(context).inflate(R.layout.item_card_spinner, p2, false)

        var image = p2?.findViewById<ImageView>(R.id.cardImage)
        var name = p2?.findViewById<TextView>(R.id.cardName)
        var num = p2?.findViewById<TextView>(R.id.cardNum)

        image?.setImageResource(data.get(p0).image)
        name?.text = data.get(p0).name
        num?.text = data.get(p0).number

        return rootView

    }
}