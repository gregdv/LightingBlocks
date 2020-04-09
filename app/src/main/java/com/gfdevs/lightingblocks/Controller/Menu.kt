package com.gfdevs.lightingblocks.Controller


import android.content.Context
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
        Toast.makeText(this,"New Game button clicked!", Toast.LENGTH_LONG).show()
    }
}