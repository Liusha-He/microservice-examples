package com.liusha.coursecatalogapi.repository

import com.liusha.coursecatalogapi.entity.Course
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.util.stream.Stream

@DataJpaTest
@ActiveProfiles("test")
class CourseRepoIntegrationTest {
    @Autowired lateinit var courseRepo: CourseRepo

    @BeforeEach
    fun setUp() {
        courseRepo.deleteAll()
        val courses = listOf(
            Course(null,
                "Build RestFul APis using SpringBoot and Kotlin",
                "Development"),
            Course(null,
                "Build Reactive Microservices using Spring WebFlux/SpringBoot",
                "Development"
                ,
            ),
            Course(null,
                "Wiremock for Java Developers",
                "Development" ,
            )
        )
        courseRepo.saveAll(courses)
    }

    @Test
    fun findByNameContaining() {
        val courses = courseRepo.findByNameContaining("SpringBoot")
        Assertions.assertEquals(2, courses.size)
    }

    @Test
    fun findCoursesByName() {
        val courses = courseRepo.findCoursesByName("SpringBoot")
        Assertions.assertEquals(2, courses.size)
    }

    @ParameterizedTest
    @MethodSource("courseAndSize")
    fun findCourseBtName_approach2(name: String, expectedSize: Int) {
        val courses = courseRepo.findCoursesByName(name)
        Assertions.assertEquals(expectedSize, courses.size)
    }

    companion object {
        @JvmStatic
        fun courseAndSize(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("SpringBoot", 2),
                Arguments.arguments("Wiremock", 1)
            )
        }
    }
}