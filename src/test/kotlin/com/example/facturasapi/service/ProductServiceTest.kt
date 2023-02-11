package com.example.facturasapi.service

import com.example.facturasapi.model.Product
import com.example.facturasapi.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ProductServiceTest {

  @InjectMocks
  lateinit var productService: ProductService

  @Mock
  lateinit var productRepository: ProductRepository

  var productMock = Product().apply {
    id = 1
    description = "ABH-6076"
    brand = "JAC"
    stock = 7
  }


  @Test
  fun saveProductWhenPlateIsZero() {

    Assertions.assertThrows(Exception::class.java) {
      productMock.apply { description = "0" }
      Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
      productService.save(productMock)
    }
  }

  @Test
  fun saveProductWhenStockIsZero() {

    Assertions.assertThrows(Exception::class.java) {
      productMock.apply { stock }
      Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
      productService.save(productMock)
    }
  }

    @Test
    fun letterInitByProvinceOfCar() {
      Assertions.assertThrows(Exception::class.java) {
        val letra = Regex("^a")
        productMock.apply { description = "ABH-607" }
        Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
        productService.save(productMock)

      }
    }


  @Test
  fun saveProductWhenBrandIsBlank() {

    Assertions.assertThrows(Exception::class.java) {
      productMock.apply { brand = "" }
      Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
      productService.save(productMock)
    }


  }

  @Test
  fun saveWhenIsSevenDigits() {

    Assertions.assertThrows(Exception::class.java) {
      productMock.apply { description = "ABH-607" }
      Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
      productService.save(productMock)
    }


  }



}


