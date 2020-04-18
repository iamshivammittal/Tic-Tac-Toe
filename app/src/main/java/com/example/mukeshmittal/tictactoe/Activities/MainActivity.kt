package com.example.mukeshmittal.tictactoe.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mukeshmittal.tictactoe.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var board:Array<Array<Button>>
    var boardStatus=Array(3){IntArray(3)}
    var player :Boolean= false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board= arrayOf(
            arrayOf(button,button2,button3),
                    arrayOf(button4,button5,button6),
        arrayOf(button7,button8,button9)
        )
        for(i in board){
            for(button in i){
                button.setOnClickListener(this)
            }
        }
        for(i in 0..2){
            for(j in 0..2){
                boardStatus[i][j]= -1
            }
        }
      resetBtn.setOnClickListener {
          for(i in 0..2){
              for(j in 0..2){
                  boardStatus[i][j]= -1
              }
          }
          for(i in board){
              for(button in i){
                  button.isEnabled=true
                  button.text=""
              }
          }
      }

    }

    override fun onClick(view: View) {
        player=!player
        when(view.id){
            R.id.button -> updateValue(0,0)
            R.id.button2 -> updateValue(0,1)
            R.id.button3 -> updateValue(0,2)
            R.id.button4 -> updateValue(1,0)
            R.id.button5 -> updateValue(1,1)
            R.id.button6 -> updateValue(1,2)
            R.id.button7 -> updateValue(2,0)
            R.id.button8 -> updateValue(2,1)
            R.id.button9 -> updateValue(2,2)

        }
        val text:String
        if(player==true){
            text="Player X turn"
        }
        else{
            text="Player 0 turn"
        }
        displayTv.text=text
        checkWinner()
    }

    private fun checkWinner() {
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                displayTv.text = "Player X is Winner"
                disableButton()
            } else if (boardStatus[0][0] == 0) {
                displayTv.text = "Player 0 is Winner"
                disableButton()
            }
        }
        if (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]) {
            if (boardStatus[0][2] == 1) {
                displayTv.text = "Player X is Winner"
                disableButton()
            } else if (boardStatus[0][2] == 0) {
                displayTv.text = "Player 0 is Winner"
                disableButton()
            }
        }
        //Vertical coloumns
        for (i in 0..2) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {
                if (boardStatus[0][i] == 1) {
                    displayTv.text = "Player X is Winner"
                    disableButton()
                } else if (boardStatus[0][i] == 0) {
                    displayTv.text = "Player 0 is Winner"
                    disableButton()
                }
            }
        }
        //Horizontal rows
        for (i in 0..2) {
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]) {
                if (boardStatus[i][0] == 1) {
                    displayTv.text = "Player X is Winner"
                    disableButton()
                } else if (boardStatus[i][0] == 0) {
                    displayTv.text = "Player 0 is Winner"
                    disableButton()
                }
            }
        }
    }
        private fun disableButton() {
            for(i in board){
                for(button in i){
                    button.isEnabled=false
                }
            }
        }

    private fun updateValue(x: Int, y: Int) {
        val text:String
        val value:Int
        if(player==true){
            text="X"
            value=1
        }
        else{
            text="0"
            value=0
        }
        board[x][y].text=text
        board[x][y].isEnabled=false
   boardStatus[x][y]=value
    }
}


