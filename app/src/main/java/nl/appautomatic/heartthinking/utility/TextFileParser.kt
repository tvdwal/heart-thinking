package nl.appautomatic.heartthinking.utility

import nl.appautomatic.heartthinking.poker.Card
import nl.appautomatic.heartthinking.poker.Hand
import nl.appautomatic.heartthinking.poker.Player

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
    var testHand2 = """"PokerStars Zoom Hand #185173787084:  Hold'em No Limit (${'$'}0.01/${'$'}0.02) - 2018/04/13 17:20:41 CET [2018/04/13 11:20:41 ET]
Table 'Halley' 6-max Seat #1 is the button
Seat 1: Shinto61 ($1.98 in chips)
Seat 2: Mariyan1987 ($1.96 in chips)
Seat 3: Wenrex ($4.32 in chips)
Seat 4: Yoshka.SB ($2 in chips)
Seat 5: BrownieBash ($2.09 in chips)
Seat 6: pyshista ($2.63 in chips)
Mariyan1987: posts small blind $0.01
Wenrex: posts big blind $0.02
*** HOLE CARDS ***
Dealt to BrownieBash [9c 2h]
Yoshka.SB: folds
BrownieBash has timed out
BrownieBash: folds
pyshista: folds
Shinto61: folds
Mariyan1987: folds
Uncalled bet ($0.01) returned to Wenrex
Wenrex collected $0.02 from pot
Wenrex: doesn't show hand
*** SUMMARY ***
Total pot $0.02 | Rake $0
Seat 1: Shinto61 (button) folded before Flop (didn't bet)
Seat 2: Mariyan1987 (small blind) folded before Flop
Seat 3: Wenrex (big blind) collected ($0.02)
Seat 4: Yoshka.SB folded before Flop (didn't bet)
Seat 5: BrownieBash folded before Flop (didn't bet)
Seat 6: pyshista folded before Flop (didn't bet)
""""
    var testHand3 = """"PokerStars Zoom Hand #185173784845:  Hold'em No Limit (${'$'}0.01/${'$'}0.02) - 2018/04/13 17:20:37 CET [2018/04/13 11:20:37 ET]
Table 'Halley' 6-max Seat #1 is the button
Seat 1: BrownieBash ($2.09 in chips)
Seat 2: qqqqall2 ($1.83 in chips)
Seat 3: Petrovich415 ($2.17 in chips)
Seat 4: d@mir-01 ($2.08 in chips)
Seat 5: Egen74 ($2.51 in chips)
Seat 6: 031968 ($1.23 in chips)
qqqqall2: posts small blind $0.01
Petrovich415: posts big blind $0.02
*** HOLE CARDS ***
Dealt to BrownieBash [Qd 6s]
d@mir-01: raises $0.04 to $0.06
Egen74: folds
031968: folds
BrownieBash: folds
qqqqall2: folds
Petrovich415: folds
Uncalled bet ($0.04) returned to d@mir-01
d@mir-01 collected $0.05 from pot
d@mir-01: doesn't show hand
*** SUMMARY ***
Total pot $0.05 | Rake $0
Seat 1: BrownieBash (button) folded before Flop (didn't bet)
Seat 2: qqqqall2 (small blind) folded before Flop
Seat 3: Petrovich415 (big blind) folded before Flop
Seat 4: d@mir-01 collected ($0.05)
Seat 5: Egen74 folded before Flop (didn't bet)
Seat 6: 031968 folded before Flop (didn't bet)
""""
    var hands: ArrayList<Hand> = ArrayList()
    var handsIndex: Int = 0

    init {
        hands.add(parseHand(testHand))
        hands.add(parseHand(testHand2))
        hands.add(parseHand(testHand3))
    }

    fun getHandForHandId(handId: String): Hand {
        for (hand in hands) {
            if (hand.handId == handId)
                return hand
        }
        return Hand()
    }

    private fun parseHand(source: String): Hand {
        var parsedHand = Hand()
        val lines = source.split("\n")
        var lineIndex = 0
        //TODO: Replace if-statements with regex whenever possible

        parsedHand.handId = lines[lineIndex].substringAfter("#").substringBefore(":")
        lineIndex++

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