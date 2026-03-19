package org.example.testreactor

import org.example.testreactor.entities.Movie
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

//KOTLIN
@RestController
@RequestMapping("/api/movies")
class MovieController(var movieService: MovieService) {

    //http://localhost:8989/api/movies
    @GetMapping
    fun getAllMovies(): Flux<Movie> = movieService.getAllMovies()

    //http://localhost:8989/api/movies/1
    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: Long): Mono<Movie> = movieService.getMovieById(id)
}