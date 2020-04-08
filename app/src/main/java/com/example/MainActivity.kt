package com.example

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }

        val products = listOf(
            Product("iPod", "Sergio", 2020, 260.34),
            Product("Pixel", "Apple", 2018, 34.34),
            Product("Mac", "Nikola", 2010, 94.00),
            Product("Monitor", "Melony", 1995, 12.90),
            Product("Kotlin", "PComp", 2020, 55.50),
            Product("VAZ2110", "AutoVAZ", 1960, 65.10)
        )

        var totalCost = 0.0

        products.forEach {
            d("daniel", "Products is: ${it.name}")
            productsTextView.append("${it.name} by ${it.owner} - $ ${it.cost}\n\n")
            totalCost += it.cost
        }
        totalCostTextView.text = "TOTAL: $ $totalCost"



    }
}
