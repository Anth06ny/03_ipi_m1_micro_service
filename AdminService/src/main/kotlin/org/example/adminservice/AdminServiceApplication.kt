package org.example.adminservice

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableAdminServer
@SpringBootApplication
class AdminServiceApplication

fun main(args: Array<String>) {
    runApplication<AdminServiceApplication>(*args)
}
