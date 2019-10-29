package com.rgabay.api

import com.rgabay.API_VERSION
import com.rgabay.model.Person
import com.rgabay.model.Request
import com.rgabay.repository.Repository
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post

const val ADD_PERSON_ENDPOINT = "${API_VERSION}/addperson"

fun Route.addperson(db:Repository){

    post(ADD_PERSON_ENDPOINT){
        val request = call.receive<Request>()
        val p = db.add(Person(request.name, request.occupation))
        call.respond(p)
    }
}