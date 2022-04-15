package com.liusha.ecommerceinkotlin.entity

import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.util.*
import javax.persistence.*


@Entity
@Table(name="product")
@Data
class Product(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id") private val id: Long,
              @Column(name = "sku") private val sku: String,
              @Column(name = "name") private val name: String,
              @Column(name = "description") private val description: String,
              @Column(name = "unit_price") private val unitPrice: BigDecimal,
              @Column(name = "image_url") private val imageURL: String,
              @Column(name = "active") private val active: Boolean,
              @Column(name = "units_in_stock") private val unitsInStock: Int,
              @ManyToOne @JoinColumn(name = "category_id", nullable = false) private val category: ProductCategory,
              @Column(name = "date_created") @CreationTimestamp private val dateCreated: Date,
              @Column(name = "last_updated") @UpdateTimestamp private val lastUpdated: Date)
{

}