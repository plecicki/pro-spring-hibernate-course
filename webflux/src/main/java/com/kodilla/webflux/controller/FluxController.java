package com.kodilla.webflux.controller;

import com.kodilla.webflux.domain.BookDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {

    @GetMapping(value = "/strings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getStrings() {
        return Flux
                .just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<BookDto> getBookDtos() {
        return Flux
                .just(new BookDto("AAA", "AAA", 2000),
                        new BookDto("BBB", "BBB", 2001),
                        new BookDto("CCC", "CCC", 2002),
                        new BookDto("DDD", "DDD", 2003))
                .log();
    }
}
