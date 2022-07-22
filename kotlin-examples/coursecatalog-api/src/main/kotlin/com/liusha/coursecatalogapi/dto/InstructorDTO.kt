package com.liusha.coursecatalogapi.dto

import javax.validation.constraints.NotBlank

data class InstructorDTO(
    val id: Int?,
    @get:NotBlank(message = "instructor name is required")
    var name: String
)
