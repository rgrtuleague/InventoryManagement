package com.example

class ProductData {
    fun allProducts(): List<Product> {
        val products = listOf(
            Product("iPod", "Sergio", 2020, 60.34),
            Product("Pixel", "Apple", 2018, 34.34),
            Product("Mac", "Nikola", 2010, 94.00),
            Product("Monitor", "Melony", 1995, 12.90),
            Product("Kotlin", "PComp", 2020, 55.50),
            Product("VAZ2110", "AutoVAZ", 1960, 65.10)
        )
        return products
    }
}