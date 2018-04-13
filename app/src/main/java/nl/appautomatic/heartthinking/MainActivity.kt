package nl.appautomatic.heartthinking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textFileParser = TextFileParser()
        textViewHelloWorld.text = textFileParser.getNextHand()
    }
}
