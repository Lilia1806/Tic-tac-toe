package com.example.tic_tac_toe

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnTicTac(view: View) {
        val btnSelected = view as Button
        var cellID = 0
        when (btnSelected.id) {
            R.id.btnTicTac1 -> cellID = 1
            R.id.btnTicTac2 -> cellID = 2
            R.id.btnTicTac3 -> cellID = 3
            R.id.btnTicTac4 -> cellID = 4
            R.id.btnTicTac5 -> cellID = 5
            R.id.btnTicTac6 -> cellID = 6
            R.id.btnTicTac7 -> cellID = 7
            R.id.btnTicTac8 -> cellID = 8
            R.id.btnTicTac9 -> cellID = 9
        }
        GameLogic(cellID, btnSelected)
    }

    var Player1 = ArrayList<Int>()
    var Player2 = ArrayList<Int>()
    var ActivePlayer = 1
    fun GameLogic(cellId: Int, btnSelected: Button) {
        if (ActivePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.GRAY)
            Player1.add(cellId)
            ActivePlayer = 2

        } else {
            btnSelected.text = "0"
            btnSelected.setBackgroundColor(Color.GRAY)
            Player2.add(cellId)
            ActivePlayer = 1
        }
        btnSelected.isEnabled = false
        FindWinner()
    }

    fun FindWinner() {
        var winner = -1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winner = 2
        }
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winner = 1
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winner = 2
        }
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winner = 2
        }

        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winner = 2
        }
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winner = 2
        }
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winner = 2
        }
        if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9)) {
            winner = 2
        }
        if (Player1.contains(3) && Player1.contains(5) && Player1.contains(7)) {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(5) && Player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                AlertDialog.Builder(this@MainActivity).setTitle("Winner")
                    .setMessage("Player1 is Winner!!!\n\nWould You like to play again?")
                    .setPositiveButton("Yes") { dialog, which ->
                        startActivity(Intent(this, MainActivity::class.java))
                    }.setNegativeButton("No") { dialog, which ->
                    }.create().show()
            } else {
                AlertDialog.Builder(this@MainActivity).setTitle("Winner")
                    .setMessage("Player2 is Winner!!!\n\nWould You like to play again?")
                    .setPositiveButton("Yes") { dialog, which ->
                        startActivity(Intent(this, MainActivity::class.java))
                    }.setNegativeButton("No") { dialog, which ->
                    }.create().show()
            }
        }
    }
}