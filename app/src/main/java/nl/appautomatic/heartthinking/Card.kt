package nl.appautomatic.heartthinking

class Card {

    var value: Value = Value.INVALID
    var suit: Suit = Suit.INVALID

    constructor(handCode: String) {
        value = getValueForCharacter(handCode[0])
        suit = getSuitForCharacter(handCode[1])
    }

    constructor(cardValue: Value, cardSuit: Suit) {
        value = cardValue
        suit = cardSuit
    }

    fun imageResource(): Int {
        return when (suit) {
            Suit.SPADES -> imageResourceSpades()
            Suit.HEARTS -> imageResourceHearts()
            Suit.CLUBS -> imageResourceClubs()
            Suit.DIAMONDS -> imageResourceDiamonds()
            else -> {
                android.R.drawable.stat_notify_error
            }
        }
    }

    private fun imageResourceSpades(): Int {
        return when (value) {
            Value.TWO -> R.drawable.spades2
                Value.THREE -> R.drawable.spades3
                Value.FOUR -> R.drawable.spades4
                Value.FIVE -> R.drawable.spades5
                Value.SIX -> R.drawable.spades6
                Value.SEVEN -> R.drawable.spades7
                Value.EIGHT -> R.drawable.spades8
                Value.NINE -> R.drawable.spades9
                Value.TEN -> R.drawable.spades10
                Value.JACK -> R.drawable.spades_jack
                Value.QUEEN -> R.drawable.spades_queen
                Value.KING -> R.drawable.spades_king
                Value.ACE -> R.drawable.spades_ace
            else -> {
                android.R.drawable.stat_notify_error
            }
        }
    }

    private fun imageResourceHearts(): Int {
        return when (value) {
            Value.TWO -> R.drawable.hearts2
            Value.THREE -> R.drawable.hearts3
            Value.FOUR -> R.drawable.hearts4
            Value.FIVE -> R.drawable.hearts5
            Value.SIX -> R.drawable.hearts6
            Value.SEVEN -> R.drawable.hearts7
            Value.EIGHT -> R.drawable.hearts8
            Value.NINE -> R.drawable.hearts9
            Value.TEN -> R.drawable.hearts10
            Value.JACK -> R.drawable.hearts_jack
            Value.QUEEN -> R.drawable.hearts_queen
            Value.KING -> R.drawable.hearts_king
            Value.ACE -> R.drawable.hearts_ace
            else -> {
                android.R.drawable.stat_notify_error
            }
        }
    }

    private fun imageResourceClubs(): Int {
        return when (value) {
            Value.TWO -> R.drawable.clubs2
            Value.THREE -> R.drawable.clubs3
            Value.FOUR -> R.drawable.clubs4
            Value.FIVE -> R.drawable.clubs5
            Value.SIX -> R.drawable.clubs6
            Value.SEVEN -> R.drawable.clubs7
            Value.EIGHT -> R.drawable.clubs8
            Value.NINE -> R.drawable.clubs9
            Value.TEN -> R.drawable.clubs10
            Value.JACK -> R.drawable.clubs_jack
            Value.QUEEN -> R.drawable.clubs_queen
            Value.KING -> R.drawable.clubs_king
            Value.ACE -> R.drawable.clubs_ace
            else -> {
                android.R.drawable.stat_notify_error
            }
        }
    }

    private fun imageResourceDiamonds(): Int {
        return when (value) {
            Value.TWO -> R.drawable.diamonds2
            Value.THREE -> R.drawable.diamonds3
            Value.FOUR -> R.drawable.diamonds4
            Value.FIVE -> R.drawable.diamonds5
            Value.SIX -> R.drawable.diamonds6
            Value.SEVEN -> R.drawable.diamonds7
            Value.EIGHT -> R.drawable.diamonds8
            Value.NINE -> R.drawable.diamonds9
            Value.TEN -> R.drawable.diamonds10
            Value.JACK -> R.drawable.diamonds_jack
            Value.QUEEN -> R.drawable.diamonds_queen
            Value.KING -> R.drawable.diamonds_king
            Value.ACE -> R.drawable.diamonds_ace
            else -> {
                android.R.drawable.stat_notify_error
            }
        }
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