package com.gfdevs.lightingblocks.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gfdevs.lightingblocks.Utilities.BaseActivity
import com.gfdevs.lightingblocks.R

class Menu : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
        println("Menu")
    }

    fun newGameBtnClicked(view: View){

        val gameIntent = Intent(this, GameActivity::class.java)
        startActivity(gameIntent)
    }

    fun continueBtnClicked(view: View){
        Toast.makeText(this,"Continue button clicked!", Toast.LENGTH_SHORT).show()
    }

    fun highscoreBtnClicked(view: View){
        Toast.makeText(this,"Highscore button clicked!", Toast.LENGTH_SHORT).show()
    }

    fun settingsBtnClicked(view: View){
        Toast.makeText(this,"Setting button clicked!", Toast.LENGTH_SHORT).show()
    }

}