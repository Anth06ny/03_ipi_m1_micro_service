package org.example.eurekaserver

import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//Kotlin
@Configuration
class AppConfig {

    //Permet de stocker les 100 dernières requêtes pour Actuator
    @Bean
    fun createTraceRepository(): InMemoryHttpExchangeRepository {
        return InMemoryHttpExchangeRepository()
    }
}