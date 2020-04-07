package com.example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.goToAddProduct
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)

        goToAddProduct.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }
// We'll use this later, not right now--------------------------
//        val preference = getSharedPreferences("database", Context.MODE_PRIVATE)
//        val savedName = preference.getString("savedProductName", "This value doesn't exist")
//        d("daniel", "saved message is : $savedName")

//        // https://finepointmobile.com/api/inventory/v1/message
//
//        lastSavedProduct.text = savedName

        lifecycleScope.launch(Dispatchers.IO) {
            val specialMessage = URL("https://finepointmobile.com/api/inventory/v1/message").readText()
            d("daniel", "The message is: $specialMessage")
            //lastSavedProduct.text = specialMessage
        }

    }
}
