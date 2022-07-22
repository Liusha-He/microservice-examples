package com.liusha.coursecatalogapi.repository

import com.liusha.coursecatalogapi.entity.Course
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CourseRepo: CrudRepository<Course, Int> {
    fun findByNameContaining(courseName: String): List<Course>
    @Query(value = "SELECT * FROM COURSES WHERE name like %?1%", nativeQuery = true)
    fun findCoursesByName(courseName: String): List<Course>
}
