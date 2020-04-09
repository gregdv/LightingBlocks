package com.gfdevs.lightingblocks.Controller

import android.content.Intent
import android.os.Bundle
import com.gfdevs.lightingblocks.Utilities.BaseActivity
import com.gfdevs.lightingblocks.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout.setOnClickListener(){
            println("Screen has been tapped")
            val menuIntent = Intent (this, Menu::class.java)
            startActivity(menuIntent)
        }

    }


}


/*

/ Turned off buttons before clicking on start label

menuButtonVisibilityChange(false)

continueBtn.isEnabled = false

startTxt.setOnClickListener(){
    startTxt.isVisible = false
    menuButtonVisibilityChange(true)
}

newGameBtn.setOnClickListener{
    println("New game clicked")
}

continueBtn.setOnClickListener {
    println("Continue clicked")
}

highscoreBtn.setOnClickListener{
    println("Highscore clicked")
}
}

fun menuButtonVisibilityChange(status: Boolean){
    newGameBtn.isVisible = status
    continueBtn.isVisible = status
    highscoreBtn.isVisible = status
    settingsBtn.isVisible = status
}
 */