package org.example.testreactor.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Table("MOVIES")
data class Movie(
    @Id // Indique la clé primaire
    var id: Long? = null,
    var title: String? = null,
    var length: Int? = null
)

//Kotlin
interface MovieRepository : ReactiveCrudRepository<Movie, Long> {
    // Méthode personnalisée pour rechercher par titre
    fun findById(id: Long?): Mono<Movie>
}