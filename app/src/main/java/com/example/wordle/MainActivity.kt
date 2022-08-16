package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

import kotlin.properties.Delegates

var currentRow by Delegates.notNull<Int>()

lateinit var list1: List<TextInputLayout>
lateinit var list2: List<TextInputLayout>
lateinit var list3: List<TextInputLayout>
lateinit var list4: List<TextInputLayout>
lateinit var list5: List<TextInputLayout>
lateinit var list6: List<TextInputLayout>

lateinit var word: String
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        list1 = listOf(Box01, Box02, Box03, Box04, Box05)
        list2 = listOf(Box06, Box07, Box08, Box09, Box10)
        list3 = listOf(Box11, Box12, Box13, Box14, Box15)
        list4 = listOf(Box16, Box17, Box18, Box19, Box20)
        list5 = listOf(Box21, Box22, Box23, Box24, Box25)
        list6 = listOf(Box26, Box27, Box28, Box29, Box30)

        currentRow = 1

        greyOut()
        rowControll()

        for (index in list1.indices) {
            list1[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list1[index].editText?.text?.length == 1) {
                    if (list1[index] == list1.last()) {
                        list1[index].requestFocus()
                    } else {
                        list1[index + 1].requestFocus()
                    }
                }
                if (list1[index].editText?.text?.length == 0) {
                    if (list1[index] == list1.first()) {
                        list1[index].requestFocus()
                    } else {
                        list1[index - 1].requestFocus()
                    }
                }
            }
        }

        for (index in list2.indices) {
            list2[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list2[index].editText?.text?.length == 1) {
                    if (list2[index] == list2.last()) {
                        list2[index].requestFocus()
                    } else {
                        list2[index + 1].requestFocus()
                    }
                }
                if (list2[index].editText?.text?.length == 0) {
                    if (list2[index] == list2.first()) {
                        list2[index].requestFocus()
                    } else {
                        list2[index - 1].requestFocus()
                    }
                }
            }
        }

        for (index in list3.indices) {
            list3[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list3[index].editText?.text?.length == 1) {
                    if (list3[index] == list3.last()) {
                        list3[index].requestFocus()
                    } else {
                        list3[index + 1].requestFocus()
                    }
                }
                if (list3[index].editText?.text?.length == 0) {
                    if (list3[index] == list3.first()) {
                        list3[index].requestFocus()
                    } else {
                        list3[index - 1].requestFocus()
                    }
                }
            }
        }

        for (index in list5.indices) {
            list5[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list5[index].editText?.text?.length == 1) {
                    if (list5[index] == list5.last()) {
                        list5[index].requestFocus()
                    } else {
                        list5[index + 1].requestFocus()
                    }
                }
                if (list5[index].editText?.text?.length == 0) {
                    if (list5[index] == list5.first()) {
                        list5[index].requestFocus()
                    } else {
                        list5[index - 1].requestFocus()
                    }
                }
            }
        }

        for (index in list6.indices) {
            list6[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list6[index].editText?.text?.length == 1) {
                    if (list6[index] == list6.last()) {
                        list6[index].requestFocus()
                    } else {
                        list6[index + 1].requestFocus()
                    }
                }
                if (list6[index].editText?.text?.length == 0) {
                    if (list6[index] == list6.first()) {
                        list6[index].requestFocus()
                    } else {
                        list6[index - 1].requestFocus()
                    }
                }
            }
        }

        for (index in list4.indices) {
            list4[index].editText?.doOnTextChanged { text, start, count, after ->
                if (list4[index].editText?.text?.length == 1) {
                    if (list4[index] == list4.last()) {
                        list4[index].requestFocus()
                    } else {
                        list4[index + 1].requestFocus()
                    }
                }
                if (list4[index].editText?.text?.length == 0) {
                    if (list4[index] == list4.first()) {
                        list4[index].requestFocus()
                    } else {
                        list4[index - 1].requestFocus()
                    }
                }
            }
        }
        rowControll()
    }


    fun Test(view: View){
        var rows = listOf(list1, list2, list3, list4, list5, list6)

        var currentList = rows[currentRow-1]
        var currentWord = ""
        var index = 0

        for (element in currentList){
            currentWord = currentWord + element.editText?.text
        }

        for (element in currentList){
            if (word.contains(element.editText?.text.toString())){
                element.setBackgroundColor(Color.parseColor("#33FFFF00"))
            }
        }

        for (element in currentList){
            if (word[index].toString() == element.editText?.text.toString()){
                element.setBackgroundColor(Color.parseColor("#3300FF00"))
            }
            index += 1
        }


        nextRow()
    }

    fun nextRow(){
        currentRow += 1
        greyOut()
        rowControll()

        if (currentRow == 7){
            Toast.makeText(applicationContext, "Game over", Toast.LENGTH_SHORT).show()
            val gameOver.text = "The word was: "+word.toString()
            val gameOver.isVisible = true

        }

    }

    fun greyOut(){

        for (element in list1){
            element.editText?.setInputType(InputType.TYPE_NULL)
            //element.setBackgroundColor(Color.parseColor("#000000"))
            element.isEnabled = false
        }
        for (element in list2){
            element.editText?.setInputType(InputType.TYPE_NULL)
            element.isEnabled = false
        }
        for (element in list3){
            element.editText?.setInputType(InputType.TYPE_NULL)
            element.isEnabled = false
        }
        for (element in list4){
            element.editText?.setInputType(InputType.TYPE_NULL)
            element.isEnabled = false
        }
        for (element in list5){
            element.editText?.setInputType(InputType.TYPE_NULL)
            element.isEnabled = false
        }
        for (element in list6){
            element.editText?.setInputType(InputType.TYPE_NULL)
            element.isEnabled = false
        }
    }

    fun rowControll(){
        if (currentRow == 1){
            for (element in list1){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 2){
            for (element in list2){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 3){
            for (element in list3){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 4){
            for (element in list4){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 5){
            for (element in list5){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
        if (currentRow == 6){
            for (element in list6){
                element.editText?.setInputType(InputType.TYPE_CLASS_TEXT)
                element.isEnabled = true
            }
        }
    }





}
