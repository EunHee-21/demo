package com.example.demo

import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication

@EnableJpaAuditing
@SpringBootApplication
object DemoApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(DemoApplication::class.java, *args)
    }
}