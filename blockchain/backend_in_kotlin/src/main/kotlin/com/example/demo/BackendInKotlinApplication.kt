package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendInKotlinApplication

fun main(args: Array<String>) {
	runApplication<BackendInKotlinApplication>(*args)
}
