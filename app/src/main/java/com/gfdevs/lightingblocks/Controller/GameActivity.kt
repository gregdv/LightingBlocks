package com.gfdevs.lightingblocks.Controller

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.gfdevs.lightingblocks.R
import com.gfdevs.lightingblocks.Utilities.BaseActivity

import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        println("Menu")

    }

}
