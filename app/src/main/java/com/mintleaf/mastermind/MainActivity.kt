package com.mintleaf.mastermind

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mintleaf.mastermind.ui.theme.MastermindTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page1)
        var buttonClicked = findViewById<Button>(R.id.button)
        var secretNumber = ""
        for (i in 0..3) {
            secretNumber += ((0..9).random()).toString()
        }
        buttonClicked.setOnClickListener {
            setContentView(R.layout.page2)
            var Text = findViewById<TextView>(R.id.textView)
            var Text2 = findViewById<TextView>(R.id.textView2)
            var Number = findViewById<EditText>(R.id.editTextNumber)
            var finalvalue = (Number.text).toString()
            Text.text = "****"
            buttonClicked = findViewById<Button>(R.id.button)
            buttonClicked.setOnClickListener {
                Text2.text = "Guess the number"
                Number = findViewById<EditText>(R.id.editTextNumber)
                finalvalue = (Number.text).toString()
                var correctValue = ""
                if (finalvalue.length == 4) {
                    var correct = true
                    for (i in 0..3) {
                        if (finalvalue[i] == secretNumber[i]) {
                            correctValue += finalvalue[i]
                        } else {
                            correctValue += "*"
                            correct = false
                        }
                    }
                    if (correct) {
                        setContentView(R.layout.page3)
                        buttonClicked = findViewById<Button>(R.id.button)
                        buttonClicked.setOnClickListener {
                            System.exit(0)
                        }
                    }
                    Text.text = correctValue

                }
                else {
                    Text2.text = "Please input a FOUR digit number"
                }
            }
        }
        }
    }