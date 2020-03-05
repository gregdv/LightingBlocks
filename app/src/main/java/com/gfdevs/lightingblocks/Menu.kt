package com.gfdevs.lightingblocks


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Menu : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
        println("Menu")
    }
}