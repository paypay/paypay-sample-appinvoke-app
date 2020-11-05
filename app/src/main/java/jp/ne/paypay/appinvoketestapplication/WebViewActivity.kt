package jp.ne.paypay.appinvoketestapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qr_web_main)

        intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://app-invoke-demo.herokuapp.com/index")
        Log.i("intent success", "shouldOverrideUrlLoading")

        val codeWeb: WebView = findViewById(R.id.qrcode_webview)
        codeWeb.loadUrl("https://app-invoke-demo.herokuapp.com/index")

        val settings = codeWeb.settings
        settings.domStorageEnabled = true
        settings.javaScriptEnabled = true
        codeWeb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
                Log.i("shouldOverrideUrlLoading", "shouldOverrideUrlLoading: $url")
                val intent: Intent
                if (url != null) {
                    if (url.contains("https://stg-www.sandbox.paypay.ne.jp/app/cashier")) {
                        intent = getPackageManager().getLaunchIntentForPackage("jp.ne.paypay.android.app")!!
//                        intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        Log.i("intent passed", "shouldOverrideUrlLoading")
                        intent.data = Uri.parse(url)
                        intent.addCategory(Intent.CATEGORY_BROWSABLE)
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent)
                        }
                        Log.i("intent data", intent.data.toString())
                        finish()
                        return true
                    }
                    if (url.startsWith("https") && url.startsWith("https://www.paypay.ne.jp/app/cashier")) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent)
                        }
                        finish()
                        return true
                    }
                    if (url.startsWith("https") && url.startsWith("https://stg-www.paypay-corp.co.jp/app/cashier")) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent)
                        }
                        finish()
                        return true
                    }
                    if (url.startsWith("https") && url.startsWith("https://stg-www.sandbox.paypay.ne.jp/app/cashier")) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent)
                        }
                        finish()
                        return true
                    }
                }
                return false
            }
        }
    }


}