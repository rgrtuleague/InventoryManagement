package com.example

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import com.example.AppConfig.Companion.filterByName
import com.example.AppConfig.Companion.maxCost
import com.example.AppConfig.Companion.minCost
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }

        val products = ProductData().allProducts()

        var totalCost = 0.0

        products.forEach {
            d("daniel", "Products is: ${it.name}")
            if (it.cost < maxCost && it.cost > minCost && it.owner == filterByName) {
                productsTextView.append("${it.name} by ${it.owner} - $ ${it.cost}\n\n")
                totalCost += it.cost
            }
        }
        totalCostTextView.text = "TOTAL: $ $totalCost"



    }
}
