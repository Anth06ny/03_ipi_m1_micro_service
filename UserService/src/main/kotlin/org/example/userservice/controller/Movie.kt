package org.example.userservice.controller





data class MoviesEntityResponse(val _embedded : MoviesEntityArray)
data class MoviesEntityArray(val movieEntities : List<MovieEntity>)

data class MovieEntity(
    var id: Long? = null,
    var title: String = "",
    var length: Int = 0,
)

/**
 * { "_embedded" : { "movieEntities" : [ { "_links" : { "self" : { "href" : "http://localhost:8081/movieEntities/1" }, "movieEntity" : { "href" : "http://localhost:8081/movieEntities/1" } }, "title" : "blabla", "length" : 200 }, { "_links" : { "self" : { "href" : "http://localhost:8081/movieEntities/2" }, "movieEntity" : { "href" : "http://localhost:8081/movieEntities/2" } }, "title" : "toto", "length" : 100 }, { "_links" : { "self" : { "href" : "http://localhost:8081/movieEntities/3" }, "movieEntity" : { "href" : "http://localhost:8081/movieEntities/3" } }, "title" : "Toto", "length" : 256 }, { "_links" : { "self" : { "href" : "http://localhost:8081/movieEntities/4" }, "movieEntity" : { "href" : "http://localhost:8081/movieEntities/4" } }, "title" : "Toto2", "length" : 45 }, { "_links" : { "self" : { "href" : "http://localhost:8081/movieEntities/5" }, "movieEntity" : { "href" : "http://localhost:8081/movieEntities/5" } }, "title" : "Tot23", "length" : 2526 } ] }, "_links" : { "self" : { "href" : "http://localhost:8081/movieEntities?page=0&size=20" }, "profile" : { "href" : "http://localhost:8081/profile/movieEntities" } }, "page" : { "number" : 0, "size" : 20, "totalElements" : 5, "totalPages" : 1 } }
 */