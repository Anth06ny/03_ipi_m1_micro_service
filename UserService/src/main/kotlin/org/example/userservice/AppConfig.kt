package org.example.userservice

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class AppConfig {

    //Permet de stocker les 100 dernières requêtes pour Actuator
    @Bean
    fun createTraceRepository(): InMemoryHttpExchangeRepository {
        return InMemoryHttpExchangeRepository()
    }

    @Bean
    @Qualifier("normal")
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    @LoadBalanced
    @Qualifier("lb")
    fun restTemplate2(): RestTemplate {
        return RestTemplate()
    }
}