package com.liusha.coursecatalogapi.service

import com.liusha.coursecatalogapi.dto.CourseDTO
import com.liusha.coursecatalogapi.entity.Course
import com.liusha.coursecatalogapi.exception.CourseNotFoundException
import com.liusha.coursecatalogapi.repository.CourseRepo
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepo: CourseRepo) {
    companion object: KLogging()

    fun createCourse(course: CourseDTO): CourseDTO {
        val courseEntity: Course = course.let {
            Course(null, it.name, it.category)
        }
        courseRepo.save(courseEntity)

        logger.info("Saved course is: $courseEntity")

        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }

    fun retrieveAllCourses(courseName: String? = null): List<CourseDTO> {
        val courses = courseName?.let {
            courseRepo.findCoursesByName(courseName)
        } ?: courseRepo.findAll()
        return courses.map {
            CourseDTO(it.id, it.name, it.category)
        }
    }

    fun updateCourse(course: CourseDTO, courseId: Int): CourseDTO {
        val existingCourse = courseRepo.findById(courseId)
        return if (existingCourse.isPresent) {
            existingCourse.get().let {
                it.name = course.name
                it.category = course.category
                courseRepo.save(it)
                CourseDTO(id = it.id, name = it.name, category = it.category)
            }
        } else {
            throw CourseNotFoundException("no course found fo course id ${courseId}")
        }
    }

    fun deleteCourse(courseId: Int) {
        val existingCourse = courseRepo.findById(courseId)
        return if (existingCourse.isPresent) {
            existingCourse.get().let {
                courseRepo.deleteById(courseId)
            }
        } else {
            throw CourseNotFoundException("no course found fo course id ${courseId}")
        }
    }
}