package nl.appautomatic.heartthinking

import java.io.InputStream

class TextFileParser() {
    val testHand = """PokerStars Zoom Hand #185173807438:  Hold'em No Limit ($0.01/$0.02) - 2018/04/13 17:21:17 CET [2018/04/13 11:21:17 ET]
Table 'Halley' 6-max Seat #1 is the button
Seat 1: tirilll ($2 in chips) 
Seat 2: AlekseiSerov ($2.33 in chips) 
Seat 3: nlgoldfinger ($2.33 in chips) 
Seat 4: 81denis81 ($2.57 in chips) 
Seat 5: BrownieBash ($2.09 in chips) 
Seat 6: artemvolk14 ($2.22 in chips) 
AlekseiSerov: posts small blind $0.01
nlgoldfinger: posts big blind $0.02
*** HOLE CARDS ***
Dealt to BrownieBash [8s Ts]
81denis81: folds 
BrownieBash: raises $0.02 to $0.04
artemvolk14: folds 
tirilll: folds 
AlekseiSerov: folds 
nlgoldfinger: calls $0.02
*** FLOP *** [7s 4d 6s]
nlgoldfinger: checks 
BrownieBash: bets $0.04
nlgoldfinger: raises $0.10 to $0.14
BrownieBash: calls $0.10
*** TURN *** [7s 4d 6s] [8h]
nlgoldfinger: checks 
BrownieBash: checks 
*** RIVER *** [7s 4d 6s 8h] [Ac]
nlgoldfinger: checks 
BrownieBash: checks 
*** SHOW DOWN ***
nlgoldfinger: shows [Kh Td] (high card Ace)
BrownieBash: shows [8s Ts] (a pair of Eights)
BrownieBash collected $0.36 from pot
*** SUMMARY ***
Total pot $0.37 | Rake $0.01 
Board [7s 4d 6s 8h Ac]
Seat 1: tirilll (button) folded before Flop (didn't bet)
Seat 2: AlekseiSerov (small blind) folded before Flop
Seat 3: nlgoldfinger (big blind) showed [Kh Td] and lost with high card Ace
Seat 4: 81denis81 folded before Flop (didn't bet)
Seat 5: BrownieBash showed [8s Ts] and won ($0.36) with a pair of Eights
Seat 6: artemvolk14 folded before Flop (didn't bet)"""
    var hands: ArrayList<String> = ArrayList()
    var handsIndex: Int = 0

    init {
        hands.add(testHand)
    }

    fun getNextHand() : Hand {
        return parseHand(testHand)
    }

    private fun parseHand(source: String): Hand {
        var parsedHand = Hand()
        val lines = source.split("\n")
        var lineIndex = 1

        //TODO: Replace if-statements with regex whenever possible

        parsedHand.buttonIndex = lines[lineIndex].substringAfterLast("#")[0].toString().toInt()

        lineIndex++
        var stacksizes = ArrayList<String>()
        while (lines[lineIndex].startsWith("Seat ")) {
            stacksizes.add(lines[lineIndex])
            lineIndex++
        }

        for (str in stacksizes) {
            var split = str.split(" ")
            if (!split[3].contains("$")) {
                //TODO: Add support for spaces in player names
                throw Exception("No support for players with spaces in their name so far...")
            }
            var p = Player(false, split[2], split[3].substringAfter("$").toDouble())
            parsedHand.players.add(p)
        }

        parsedHand.smallBlind = lines[lineIndex].substringAfterLast("$").toDouble()
        lineIndex++
        parsedHand.bigBlind = lines[lineIndex].substringAfterLast("$").toDouble()
        lineIndex++

        if (!lines[lineIndex].contains("HOLE CARDS")) {
            throw Exception("Something went wrong during hand-parsing before the 'HOLE CARDS' line")
        }
        lineIndex++

        val heroPlayerLineSplit = lines[lineIndex].split(" ")
        val heroPlayerIndex = parsedHand.getIndexForPlayerWithName(heroPlayerLineSplit[2])
        parsedHand.players[heroPlayerIndex].isHero = true
        parsedHand.players[heroPlayerIndex].holeCardOne = Card(heroPlayerLineSplit[3].substringAfter("["))
        parsedHand.players[heroPlayerIndex].holeCardTwo = Card(heroPlayerLineSplit[4].substringBefore("]"))

        return parsedHand
    }

}