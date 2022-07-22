package com.liusha.coursecatalogapi.repository

import com.liusha.coursecatalogapi.entity.Instructor
import org.springframework.data.repository.CrudRepository

interface InstructorRepo: CrudRepository<Instructor, Int> {
}