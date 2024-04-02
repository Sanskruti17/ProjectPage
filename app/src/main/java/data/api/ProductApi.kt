package data.api

import data.dto.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("/products")
    fun getProduct(): Response<List<Product>>

    companion object{
        const val BASE_URL = "https://dummyjson.com"
    }
}