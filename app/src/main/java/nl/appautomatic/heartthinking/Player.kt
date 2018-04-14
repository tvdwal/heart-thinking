package nl.appautomatic.heartthinking

class Player(isHero: Boolean, name: String, stackSize: Double) {

    var name: String = name
    var isHero: Boolean = isHero
    var chips: Double = stackSize
    var holeCardOne: Card? = null
    var holeCardTwo: Card? = null

    init {

    }

    fun setHoleCards(cardOne: Card, cardTwo: Card) {
        holeCardOne = cardOne
        holeCardTwo = cardTwo
    }
}