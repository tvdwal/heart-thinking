package nl.appautomatic.heartthinking.utility

import android.app.IntentService
import android.content.Intent
import android.content.Context

private const val ACTION_PARSE_HANDS = "nl.appautomatic.heartthinking.utility.action.parse_hand"

private const val PARAM_NR_OF_TEXT_FILE = "nl.appautomatic.heartthinking.utility.extra.param_text_file"
private const val PARAM_NR_OF_HANDS = "nl.appautomatic.heartthinking.utility.extra.param_nr_of_hands"

class ParserService : IntentService("ParserService") {

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_PARSE_HANDS -> {
                val nrHands = intent.getIntExtra(PARAM_NR_OF_HANDS, 0)
                val textFile = intent.getStringExtra(PARAM_NR_OF_TEXT_FILE)
                handleActionParseHands(textFile, nrHands)
            }
        }
    }

    private fun handleActionParseHands(textFile: String, nrOfHands: Int) {
        val textFileParser = TextFileParser()

    }

    companion object {
        @JvmStatic
        fun startActionParseHands(context: Context, textFile: String, nrOfHands: Int) {
            val intent = Intent(context, ParserService::class.java).apply {
                action = ACTION_PARSE_HANDS
                putExtra(PARAM_NR_OF_HANDS, nrOfHands)
                putExtra(PARAM_NR_OF_TEXT_FILE, textFile)
            }
            context.startService(intent)
        }
    }
}
