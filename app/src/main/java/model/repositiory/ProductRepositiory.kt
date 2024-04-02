package model.repositiory

import data.dto.Product

interface ProductRepositiory {
    suspend fun getProducts(): List<Product>
}