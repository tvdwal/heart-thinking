package nl.appautomatic.heartthinking.poker

class Player(isHero: Boolean, name: String, stackSize: Double) {

    var name: String = name
    var isHero: Boolean = isHero
    var chips: Double = stackSize
    var holeCardOne: Card = Card(Value.UNKNOWN, Suit.UNKNOWN)
    var holeCardTwo: Card = Card(Value.UNKNOWN, Suit.UNKNOWN)

}