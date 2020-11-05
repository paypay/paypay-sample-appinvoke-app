package jp.ne.paypay.appinvoketestapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webviewButton: Button = findViewById(R.id.launch_web)
        webviewButton.setOnClickListener {
            val webViewIntent = Intent(applicationContext, WebViewActivity::class.java)
            startActivity(webViewIntent)
        }
    }
}
