package com.liusha.ecommerceinkotlin.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "product_category")
@Getter
@Setter
class ProductCategory(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") private val id: Long,
                      @Column(name = "category_name") private val categoryName: String,
                      @OneToMany(cascade = [CascadeType.ALL], mappedBy = "category") private val products: Set<Product>)
{

}