package org.example.testreactor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestReactorApplication

fun main(args: Array<String>) {
    runApplication<TestReactorApplication>(*args)
}
