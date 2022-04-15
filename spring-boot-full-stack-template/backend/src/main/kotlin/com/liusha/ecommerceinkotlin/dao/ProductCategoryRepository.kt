package com.liusha.ecommerceinkotlin.dao

import com.liusha.ecommerceinkotlin.entity.ProductCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
interface ProductCategoryRepository: JpaRepository<ProductCategory, Long> {}