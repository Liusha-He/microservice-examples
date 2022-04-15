package com.liusha.ecommerceinkotlin.dao

import com.liusha.ecommerceinkotlin.entity.Product
import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository: JpaRepository<Product, Long> {}