package com.example.expressproject.model

import com.example.expressproject.R

class CardsList {

    fun getCardsList(): ArrayList<CardsDataClass> {
        var cards = ArrayList<CardsDataClass>()

        cards.add(CardsDataClass(R.drawable.card1, "Express Visa", "***1234"))
        cards.add(CardsDataClass(R.drawable.card2, "Express Master", "***1234"))
        cards.add(CardsDataClass(R.drawable.card3, "Expresso", "***1234"))

        return cards

    }
}