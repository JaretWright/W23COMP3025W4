package com.constantlearningdad.w23comp3025w4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.constantlearningdad.w23comp3025w4.databinding.ActivityWebBrowserBinding

class WebBrowserActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWebBrowserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBrowserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.urlButton.setOnClickListener {
            var url = binding.urlEditText.text.toString()

            //check if the URL has any text in it
            if (url.isNotEmpty())
            {
                //prepend the url with http and call the browser
                if (!(url.startsWith("http://") || url.startsWith("https://")))
                    url = "http://"+url

                //create an Implicit intent to the Action_View
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
            else
                Toast.makeText(this,"enter a url",Toast.LENGTH_LONG).show()
        }

        binding.urlBackToMainButton.setOnClickListener {
            finish()
        }
    }
}