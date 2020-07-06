package com.news

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class NewsApplication

fun main(args: Array<String>) {
    runApplication<NewsApplication>(*args)
}