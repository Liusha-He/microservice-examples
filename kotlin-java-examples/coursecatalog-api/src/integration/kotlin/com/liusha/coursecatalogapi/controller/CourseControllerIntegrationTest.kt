package com.liusha.coursecatalogapi.controller

import com.liusha.coursecatalogapi.dto.CourseDTO
import com.liusha.coursecatalogapi.entity.Course
import com.liusha.coursecatalogapi.repository.CourseRepo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.util.UriComponentsBuilder

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CourseControllerIntegrationTest {
    @Autowired
    lateinit var webTestClient: WebTestClient
    @Autowired
    lateinit var courseRepo: CourseRepo

    @BeforeEach
    fun setUp() {
        courseRepo.deleteAll()

        val courses = listOf(
            Course(null, "Build Restful APIs Using SpringBoot and Kotlin", "developer"),
            Course(null, "Build Restful APIs Using FastAPI and Python" ,"Liusha"),
            Course(null, "Android Development for Beginners", "Degere")
        )
        courseRepo.saveAll(courses)
    }

    @Test
    fun createCourse() {
        val course = CourseDTO(id = null, name = "Build Restful APIs Using SpringBoot and Kotlin", category = "developer")
        val savedCourseDTO = webTestClient.post()
            .uri("/v1/courses")
            .bodyValue(course)
            .exchange()
            .expectStatus().isCreated
            .expectBody(course::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue {
            savedCourseDTO!!.id != null
        }
        Assertions.assertTrue {
            savedCourseDTO!!.category == "developer"
        }
    }

    @Test
    fun retrieveAllCourses() {
        val courses = webTestClient.get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertEquals(3, courses!!.size)
    }

    @Test
    fun retreiveAllCoursesByName() {
        val uri = UriComponentsBuilder.fromUriString("/v1/courses")
            .queryParam("course_name", "SpringBoot")
            .toUriString()

        val courses = webTestClient.get()
            .uri(uri)
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertEquals(1, courses!!.size)
    }

    @Test
    fun updateCourse() {
        val course = Course(id = null,
            name = "Build Android App Using Python",
            category = "stranger")
        courseRepo.save(course)

        val updatedCourseDTO = CourseDTO(
            id = null,
            name = "changed title",
            category = "liusha"
        )

        val updatedCourse = webTestClient.put()
            .uri("/v1/courses/{courseId}", course.id)
            .bodyValue(updatedCourseDTO)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertEquals("changed title", updatedCourse!!.name)
        Assertions.assertEquals( "liusha", updatedCourse!!.category)
    }

    @Test
    fun deleteCourse() {
        val course = Course(id = null,
            name = "Build Android App Using Python",
            category = "stranger")
        courseRepo.save(course)

        val deletedCourse = webTestClient.delete()
            .uri("/v1/courses/{courseId}", course.id)
            .exchange()
            .expectStatus().isNoContent
    }
}
