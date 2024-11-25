package com.example.onlinegroceries.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.onlinegroceries.R
import com.example.onlinegroceries.databinding.ActivitySignInBinding
import com.example.onlinegroceries.util.Session

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    lateinit var session: Session

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.manualLoginButton.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        session = Session(this)

    /*    // Set initial focus and disable other EditTexts
        binding.edtOne.isEnabled = true
        binding.edtTwo.isEnabled = false
        binding.edtThree.isEnabled = false
        binding.edtFour.isEnabled = false

        // Open keyboard with a delay to ensure UI has fully rendered
        openKeyboardWithDelay(binding.edtOne)

        // Set text watchers for the EditTexts
        setTextWatcher(binding.edtOne, binding.edtTwo)
        setTextWatcher(binding.edtTwo, binding.edtThree)
        setTextWatcher(binding.edtThree, binding.edtFour)

        // Close keyboard when 4th EditText is filled
        setLastTextWatcher(binding.edtFour)*/
    }

    // Open keyboard for the provided EditText with a slight delay to ensure the UI is ready
    private fun openKeyboardWithDelay(editText: EditText) {
        Handler(Looper.getMainLooper()).postDelayed({
            editText.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        }, 300) // Delay for 300 milliseconds to give UI time to render
    }

    fun setTextWatcher(currentEditText: EditText, nextEditText: EditText) {
        currentEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                if (!editable.isNullOrEmpty()) {
                    // Change background color and enable next EditText
                    currentEditText.setBackgroundColor(
                        ContextCompat.getColor(this@SignInActivity, R.color.color_primary)
                    )
                    nextEditText.isEnabled = true
                    nextEditText.requestFocus()

                    // Open the keyboard for the next EditText
                    openKeyboard(nextEditText)
                } else {
                    // Reset background color and disable next EditText
                    currentEditText.setBackgroundColor(
                        ContextCompat.getColor(this@SignInActivity, R.color.rippleColor)
                    )
                    nextEditText.isEnabled = false
                }
            }
        })
    }

    // Watch for the last EditText to close the keyboard when filled
    fun setLastTextWatcher(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                if (!editable.isNullOrEmpty()) {
                    // Close the keyboard when the 4th EditText is filled
                    closeKeyboard()
                }
            }
        })
    }

    // Open keyboard for the provided EditText
    fun openKeyboard(editText: EditText) {
        editText.requestFocus() // Ensure focus is requested
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    }

    // Close the keyboard
    fun closeKeyboard() {
        val view = this.currentFocus
        view?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }
}

