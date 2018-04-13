package nl.appautomatic.heartthinking

class Player(isHero: Boolean, stackSize: Int) {

    var isHero: Boolean = isHero
    var chips: Int = stackSize
    var holeCardOne: Card? = null
    var holeCardTwo: Card? = null

    init {

    }

    fun setHoleCards(cardOne: Card, cardTwo: Card) {
        holeCardOne = cardOne
        holeCardTwo = cardTwo
    }
}