package org.example.moviesservice

import org.example.moviesservice.entities.MovieEntity
import org.example.moviesservice.entities.MoviesRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MoviesServiceApplication(val moviesRepository: MoviesRepository) : CommandLineRunner {


    override fun run(vararg args: String) {
        if(moviesRepository.count() < 5) {
            moviesRepository.save(MovieEntity(null, "Toto", 256))
            moviesRepository.save(MovieEntity(null, "Toto2", 45))
            moviesRepository.save(MovieEntity(null, "Tot23", 2526))
        }
    }

}

fun main(args: Array<String>) {
    runApplication<MoviesServiceApplication>(*args)
}
