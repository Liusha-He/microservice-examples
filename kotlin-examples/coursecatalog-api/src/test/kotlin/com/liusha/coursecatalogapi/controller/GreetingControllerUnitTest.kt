package com.liusha.coursecatalogapi.controller

import com.liusha.coursecatalogapi.service.GreetingService
import com.liusha.coursecatalogapi.controller.GreetingController
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [GreetingController::class])
@AutoConfigureWebTestClient
class GreetingControllerUnitTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var GreetingServiceMock: GreetingService

    @Test
    fun retrieveGreeting() {
        val name: String = "developer"
        every {
            GreetingServiceMock.retrieveGreeting(any())
        } returns "Hi $name, Hello from test profile"

        val result = webTestClient.get()
            .uri("/v1/greetings/{name}", name)
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()

        Assertions.assertEquals("Hi $name, Hello from test profile", result.responseBody)
    }
}