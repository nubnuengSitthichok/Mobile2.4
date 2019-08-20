package com.example.aboutme3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme3.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            doneButton.setOnClickListener {
                addNickname(it)
            }
            nameText.setOnClickListener {
                updateNickname(it)
            }

        }


    }
    private fun updateNickname (view: View) {
        binding.apply {
           nicknameEdit.visibility = View.VISIBLE
           nicknameText.visibility = View.GONE
           doneButton.visibility = View.VISIBLE

            // Set the focus to the edit text.
            nicknameEdit.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)

        }

    }

    private fun addNickname(view: View) {
        binding.apply {
            nicknameText.text = binding.nicknameEdit.text
            nicknameText.visibility = View.VISIBLE
            doneButton.visibility = View.GONE

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0 )

        }



    }
}
