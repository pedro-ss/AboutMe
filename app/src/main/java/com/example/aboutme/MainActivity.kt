package com.example.aboutme

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil
import android.hardware.input.InputManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindind: ActivityMainBinding
    private val myName: MyName = MyName("Pedro de S. Silva")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind =  DataBindingUtil.setContentView(this, R.layout.activity_main)

        bindind.myName = myName
        bindind.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View){
        bindind.apply {
            myName?.nickName = nicknameEdit.text.toString()
            invalidateAll()
            bindind.nicknameText.visibility = View.GONE
            bindind.doneButton.visibility = View.GONE
            bindind.nicknameText.visibility = View.VISIBLE
        }
        //hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken , 0)
    }
}