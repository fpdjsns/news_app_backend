package com.news.presentation

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class TestHandler {
    fun test(request: ServerRequest): Mono<ServerResponse> {
        val name = request.queryParam("name")
        return ok().bodyValue(name)
    }
}