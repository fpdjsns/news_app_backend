package com.news.presentation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
class TestRouter {
    @Bean
    fun routes(testHandler: TestHandler) = router {
        accept(APPLICATION_JSON).nest {
            GET("/test", testHandler::test)
        }
    }
}