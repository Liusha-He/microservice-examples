package com.liusha.coursecatalogapi.dto

import javax.validation.constraints.NotBlank

data class CourseDTO(
    val id: Int?,
    @get:NotBlank(message = "courseDTO.name is required")
    val name: String,

    @get:NotBlank(message = "courseDTO.category is required")
    val category: String,
)
