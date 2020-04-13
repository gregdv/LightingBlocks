package com.gfdevs.lightingblocks.Controller

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.blue
import androidx.core.view.children
import androidx.core.view.isInvisible
import androidx.core.view.updateLayoutParams
import com.gfdevs.lightingblocks.R
import com.gfdevs.lightingblocks.Utilities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.game_board.*

class GameActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        println("Menu")

    }


    fun gameBoardClicked(view: View) {

        val count = gameBoard.childCount
        println("There is $count children")

        for (child in gameBoard.children) {

            child.setOnClickListener {
                val idx = gameBoard.indexOfChild(child)
                println("Clicked on $idx")

                val imageView = child.findViewById<ImageView>(child.id)
                val imgOff = R.drawable.red_off
                val imgOn = R.drawable.red_on

                if (child.tag == 0){
                    imageView.setImageResource(imgOn)
                    child.tag = 1
                }else{
                    imageView.setImageResource(imgOff)
                    child.tag = 0
                }

            }
        }

    }


      //  val focusedChild: View = gameBoard.focusedChild

     //   println("Focused child is $focusedChild")

      //  Toast.makeText(this, "Board clicked at ${gameBoard.indexOfChild(view)} !", Toast.LENGTH_SHORT).show()
}




