package com.constantlearningdad.w23comp3025w4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.constantlearningdad.w23comp3025w4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //when the button is clicked, make sure we have some text to
        //pass to the next activity
        binding.passDetailsButton.setOnClickListener {
            var name = binding.nameEditText.text.toString()

            //if the name is not populated, inform the user
            if (name.isNotEmpty())
            {
                //pass the information to the PassDetailsActivity
                //by creating an explicit intent
                var intent = Intent(this, PassDetailsActivity::class.java)
                intent.putExtra("name",name)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Enter your name",Toast.LENGTH_LONG).show()
            }
        }
    }
}