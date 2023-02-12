package com.ecquaria.assignment2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication
class Assignment2Application

fun main(args: Array<String>) {
	runApplication<Assignment2Application>(*args)
}

@Bean
fun corsConfigurer(): WebMvcConfigurer {
	return object : WebMvcConfigurer {
		override fun addCorsMappings(registry: CorsRegistry) {
			registry.addMapping("/**")
					.allowedOrigins("*")
					.allowedMethods("GET", "PATCH", "POST")
		}
	}
}