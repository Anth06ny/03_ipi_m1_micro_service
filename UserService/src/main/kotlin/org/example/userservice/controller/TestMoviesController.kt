package org.example.userservice.controller

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/mymovies")
class TestMoviesController(
    @Qualifier("normal")
    val restTemplate: RestTemplate,
    @Qualifier("lb")
    val restTemplateLB: RestTemplate
) {

    //Accès classique par lien direct à un autre MicroService
    //http://localhost:8080/mymovies/directAccess
    //http://localhost:9090/UserService/mymovies/directAccess
    @GetMapping("/directAccess")
    fun directAccess(): List<MovieEntity>? {
        println("/directAccess")

        val res =
            restTemplate.getForObject(
                "http://localhost:8081/movieEntities",
                MoviesEntityResponse::class.java
            )

        return res?._embedded?.movieEntities
    }

    //Accès utilisant le lien de LoadBalancing
    //http://localhost:8080/mymovies/directAccessLB
    @GetMapping("/directAccessLB")
    fun directAccessLB(): List<MovieEntity>? {
        println("/directAccessLB")

        val res =
            restTemplateLB.getForObject(
                "http://MOVIESSERVICE/movieEntities",
                MoviesEntityResponse::class.java
            )

        return res?._embedded?.movieEntities
    }
}