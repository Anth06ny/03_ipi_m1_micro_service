package org.example.testreactor

import org.example.testreactor.entities.Movie
import org.example.testreactor.entities.MovieRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

//KOTLIN
@Service
class MovieService(val movieRepository: MovieRepository) {
    fun getAllMovies(): Flux<Movie> = movieRepository.findAll()

    fun getMovieById(id: Long?): Mono<Movie> = movieRepository.findById(id)
}