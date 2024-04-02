package presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.dto.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import model.repositiory.ProductRepositiory
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepositiory: ProductRepositiory
):ViewModel(){

    private val _productlist = MutableStateFlow<List<Product>>(emptyList())
    val productlist: StateFlow<List<Product>> get() = _productlist

    init {
        loadProducts()
    }

    private fun loadProducts(){
        viewModelScope.launch {
            try {
                val products = productRepositiory.getProducts()
                _productlist.value = products
            }
            catch (e:Exception){

            }
        }
    }

    private fun OnCLickProdcts(){

    }
}