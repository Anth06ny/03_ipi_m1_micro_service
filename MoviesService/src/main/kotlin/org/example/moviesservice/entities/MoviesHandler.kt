package org.example.moviesservice.entities

import org.springframework.data.rest.core.annotation.HandleAfterCreate
import org.springframework.data.rest.core.annotation.HandleAfterDelete
import org.springframework.data.rest.core.annotation.HandleAfterSave
import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.data.rest.core.annotation.HandleBeforeDelete
import org.springframework.data.rest.core.annotation.HandleBeforeSave
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component

@Component
@RepositoryEventHandler(MovieEntity::class)
class MovieEventHandler {

    // Intercepte les événements avant la création d'une nouvelle entité
    @HandleBeforeCreate
    fun handleBeforeCreate(movie: MovieEntity) {
        println("Before creating entity: $movie")
    }

    // Intercepte les événements après la création d'une nouvelle entité
    @HandleAfterCreate
    fun handleAfterCreate(movie: MovieEntity) {
        println("After creating entity: $movie")
    }

    // Intercepte les événements avant la mise à jour d'une entité existante
    @HandleBeforeSave
    fun handleBeforeSave(movie: MovieEntity) {
        println("Before saving entity: $movie")
    }

    // Intercepte les événements après la mise à jour d'une entité existante
    @HandleAfterSave
    fun handleAfterSave(movie: MovieEntity) {
        println("After saving entity: $movie")
    }

    // Intercepte les événements avant la suppression d'une entité
    @HandleBeforeDelete
    fun handleBeforeDelete(movie: MovieEntity) {
        println("Before deleting entity: $movie")
    }

    // Intercepte les événements après la suppression d'une entité
    @HandleAfterDelete
    fun handleAfterDelete(movie: MovieEntity) {
        println("After deleting entity: $movie")
    }
}