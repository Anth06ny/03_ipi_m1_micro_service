package org.example.userservice.controller

import org.example.userservice.entity.UserEntity
import org.example.userservice.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserRestController {

    //http://localhost:8080/users
    //{"login":"aaa", "password":"bbb"}
    @PostMapping
    fun createUser(@RequestBody user: UserEntity) =
        ResponseEntity(UserService.save(user), HttpStatus.CREATED)

    //http://localhost:8080/users
    //{"login":"aaa", "password":"bbb"}
    @PutMapping   ("/{id}")
    fun updateUser(@RequestBody userDetails: UserEntity, @PathVariable id: Long): ResponseEntity<UserEntity> {
        val user = UserService.findById(id)
        return if (user != null) {
            userDetails.id = id //écrase celui reçu dans le JSON au cas ou
            UserService.save(userDetails)
            ResponseEntity(userDetails, HttpStatus.OK)
        }
        else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //http://localhost:8080/users/1
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        return if (UserService.deleteById(id)) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        }
        else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    //http://localhost:8080/users
    @GetMapping
    fun getAllUsers() =
        ResponseEntity(UserService.load(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserEntity> {
        val userEntity = UserService.findById(id)
        return if (userEntity != null) {
            ResponseEntity.ok(userEntity)
        }
        else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }



    //http://localhost:8080/test
    @GetMapping("/test")
    fun test(): String {
        println("/test")
        return "helloWorld"
    }
}