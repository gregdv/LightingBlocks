package com.gfdevs.lightingblocks.Controller


import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Chronometer
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.children
import com.gfdevs.lightingblocks.R
import com.gfdevs.lightingblocks.Services.DataService
import com.gfdevs.lightingblocks.Utilities.BaseActivity
import com.gfdevs.lightingblocks.Utilities.SHAREDPREFS_FILE
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.game_board.*


class GameActivity : BaseActivity() {

    private var moveCounter = 0
    private var currentLevel = 0
    lateinit var timer: Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        val sharedPrefs = this.getSharedPreferences(SHAREDPREFS_FILE,Context.MODE_PRIVATE)
        var currentLevel = sharedPrefs.getInt("lastLevel",1)
        println("Current level is $currentLevel")
        val sharedPrefsEditor: SharedPreferences.Editor = sharedPrefs.edit()

        val timer = findViewById<View>(R.id.timeCounterTxt) as Chronometer
        timer.typeface = ResourcesCompat.getFont(this,R.font.the_girl_next_door)
        timer.start()

        levelCounterTxt.text = "" + currentLevel
        moveCounterTxt.text = "" + moveCounter

        readLevel(currentLevel)

        //set listener on gameboard sqares
        for (square in gameBoard.children){
            square.setOnClickListener {
                makeMove(square)

                moveCounterTxt.text = "" + ++moveCounter
                println("Move $moveCounter")

                val levelCompleted = checkIfLevelCompleted()
                if (levelCompleted) {
                    //check if next level exists
                    println("Levels list size ${DataService.levelLayouts.size} > current $currentLevel")
                    if (DataService.levelLayouts.size > currentLevel + 1){
                        Toast.makeText(this, "Level $currentLevel completed", Toast.LENGTH_SHORT).show()
                        ++currentLevel
                        sharedPrefsEditor.putInt("lastLevel", currentLevel)
                        sharedPrefsEditor.commit()
                        println("Saved last level $currentLevel")
                    }else {
                        Toast.makeText(this, "You have completed the last level!!!", Toast.LENGTH_SHORT).show()
                    }

                    levelCounterTxt.text = "" + currentLevel
                    restartLevel()
                }
            }
        }

    }

    fun restartLevelClicked(view: View) {
        restartLevel()
    }

    fun quitBtnClicked(view: View) {
        val sharedPrefs = this.getSharedPreferences(SHAREDPREFS_FILE,Context.MODE_PRIVATE)
        val sharedPrefsEditor: SharedPreferences.Editor = sharedPrefs.edit()
        sharedPrefsEditor.putInt("lastLevel", 1)
        sharedPrefsEditor.commit()
        restartLevel()
        Toast.makeText(this,"Game has been restarted", Toast.LENGTH_SHORT).show()
    }


    private fun restartLevel(){
        val timer = findViewById<View>(R.id.timeCounterTxt) as Chronometer

        timer.base = SystemClock.elapsedRealtime()

        moveCounter = 0
        moveCounterTxt.text = "0"

        val sharedPrefs = this.getSharedPreferences(SHAREDPREFS_FILE,Context.MODE_PRIVATE)
        var currentLevel = sharedPrefs.getInt("lastLevel",1)

        readLevel(currentLevel)
    }



    private fun readLevel(levelNumber: Int) {
        println("Start loading level $levelNumber")

        val levelLayout = DataService.levelLayouts[levelNumber].levelLayout


        println("Start loading level layout $levelLayout")

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


    fun checkIfLevelCompleted(): Boolean {
        var levelCompleted = true

        for (square in gameBoard.children){

            val squareTag = square.tag

            if (squareTag == 1){
                println("Square ${gameBoard.indexOfChild(square)}")
                levelCompleted = false
                break
            }
        }

        return levelCompleted
    }


}





