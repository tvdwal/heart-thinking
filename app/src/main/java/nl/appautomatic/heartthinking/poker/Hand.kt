package nl.appautomatic.heartthinking.poker

class Hand {
    var handId = ""
    var players: ArrayList<Player> = ArrayList()
    var pot = 0
    var buttonIndex = 0
    var smallBlind = 0.0
    var bigBlind = 0.0

    fun getIndexForPlayerWithName(name: String): Int {
        var index = 0
        for (p in players) {
            if (p.name == name) {
                return index
            }
            index++
        }
        return -1
    }

    fun numberOfPlayers(): Int {
        return players.size
    }

    fun getHeroPlayer(): Player? {
       for (p in players) {
           if (p.isHero) {
               return p
           }
       }
       return null
    }
}