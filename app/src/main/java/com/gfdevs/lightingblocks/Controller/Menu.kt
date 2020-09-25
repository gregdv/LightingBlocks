package com.gfdevs.lightingblocks.Controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gfdevs.lightingblocks.R
import com.gfdevs.lightingblocks.Utilities.BaseActivity
import com.gfdevs.lightingblocks.Utilities.SHAREDPREFS_FILE
import kotlinx.android.synthetic.main.menu.*


class Menu : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
        newGameBtn.text = "Play"
        continueBtn.isEnabled = false
        continueBtn.setTextColor(resources.getColor(R.color.material_on_surface_disabled))
        highscoreBtn.isEnabled = false
        highscoreBtn.setTextColor(resources.getColor(R.color.material_on_surface_disabled))
        settingsBtn.isEnabled = false
        settingsBtn.setTextColor(resources.getColor(R.color.material_on_surface_disabled))
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
        val sharedPrefs = this.getSharedPreferences(SHAREDPREFS_FILE,Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPrefs.edit()
        editor.putInt("lastLevel", 1)
        editor.commit()

    }

    fun settingsBtnClicked(view: View){
     //  Toast.makeText(this,"Setting button clicked!", Toast.LENGTH_SHORT).show()

        val sharedPrefs = this.getSharedPreferences(SHAREDPREFS_FILE,Context.MODE_PRIVATE)
        val txt = sharedPrefs.getInt("lastLevel",33)

        Toast.makeText(this,"Last level $txt", Toast.LENGTH_SHORT).show()
        val editor: SharedPreferences.Editor = sharedPrefs.edit()
        editor.putInt("lastLevel", 1)
        editor.commit()
    }

}