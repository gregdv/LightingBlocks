package com.gfdevs.lightingblocks.Controller


import android.content.res.Resources
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Chronometer
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.children
import com.gfdevs.lightingblocks.R
import com.gfdevs.lightingblocks.Services.DataService
import com.gfdevs.lightingblocks.Utilities.BaseActivity
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.game_board.*


class GameActivity : BaseActivity() {

    var moveCounter = 0
    var currentLevel = 2
    lateinit var timer: Chronometer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val timer = findViewById<View>(R.id.timeCounterTxt) as Chronometer
        timer.setTypeface(ResourcesCompat.getFont(this,R.font.the_girl_next_door))
        timer.start()

     //   timeCounterTxt.setText("" + timer)
        levelCounterTxt.setText("" + currentLevel)
        moveCounterTxt.setText("" + moveCounter)


        readLevel(currentLevel)
        //set listener on gameboard sqares
        for (square in gameBoard.children){
            square.setOnClickListener {
                makeMove(square)

                moveCounterTxt.setText("" + ++moveCounter)
                println("Move $moveCounter")
            }
        }

    }


    private fun readLevel(levelNumber: Int) {
        println("Start loading level $levelNumber")

        val levelLayout = DataService.levelLayouts[levelNumber].levelLayout

        for (square in gameBoard.children) {
            val idx = gameBoard.indexOfChild(square)

            if (levelLayout.contains(idx)) {
                setSquareStatus(square,true)
            } else {
                setSquareStatus(square,false)
            }
        }
    }

    private fun setSquareStatus(square: View, statusOn: Boolean){
        val idx = gameBoard.indexOfChild(square)
        val imageView = square.findViewById<ImageView>(square.id)
        val imgOff = R.drawable.red_off
        val imgOn = R.drawable.red_on
        println("statusOn is $statusOn")
        if (statusOn){
            println("Change square to on")
            imageView.setImageResource(imgOn)
            square.tag = 1
        }else if (!statusOn){
            println("Change square to off")
            imageView.setImageResource(imgOff)
            square.tag = 0
        }else{
            Log.e("Error","Error while changing square status")
        }
    }

    private fun makeMove(square: View){
        val idx = gameBoard.indexOfChild(square)
        val squareList = DataService.moveRules[idx].squaresToChanged

        for (i in squareList){
            val squareView = gameBoard.getChildAt(i)
            val squareTag = gameBoard.getChildAt(i).tag

            if (squareTag == 0){
                setSquareStatus(squareView,true)
            }else {
                setSquareStatus(squareView,false)
            }

        }

    }
}





