package nl.appautomatic.heartthinking

class Card {

    var value: Value = Value.ACE
    var suit: Suit = Suit.SPADES

    constructor(handCode: String) {
        value = getValueForCharacter(handCode[0])
        suit = getSuitForCharacter(handCode[1])
    }

    constructor(cardValue: Value, cardSuit: Suit) {
        value = cardValue
        suit = cardSuit
    }

    private fun getValueForCharacter(char: Char): Value {
        return when (char) {
            '2' -> Value.TWO
            '3' -> Value.THREE
            '4' -> Value.FOUR
            '5' -> Value.FIVE
            '6' -> Value.SIX
            '7' -> Value.SEVEN
            '8' -> Value.EIGHT
            '9' -> Value.NINE
            'T' -> Value.TEN
            'J' -> Value.JACK
            'Q' -> Value.QUEEN
            'K' -> Value.KING
            'A' -> Value.ACE
            else -> {
                Value.INVALID
            }
        }
    }

    private fun getSuitForCharacter(char: Char): Suit {
        return when (char) {
            's' -> Suit.SPADES
            'h' -> Suit.HEARTS
            'c' -> Suit.CLUBS
            'd' -> Suit.DIAMONDS

            else -> {
                Suit.INVALID
            }
        }
    }
}