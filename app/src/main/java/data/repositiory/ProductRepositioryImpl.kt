package data.repositiory

import android.app.Application
import data.api.ProductApi
import data.dto.Product
import model.repositiory.ProductRepositiory
import javax.inject.Inject

class ProductRepositioryImpl @Inject constructor(
    private val productApi: ProductApi,
):ProductRepositiory {
    override suspend fun getProducts(): List<Product> {
        return try {
            val response = productApi.getProduct()
            if(response.isSuccessful){
                response.body()?: emptyList()
            }else{
                emptyList()
            }
        }
        catch (e:Exception){
            emptyList()
        }
    }

}