package com.rgabay.api

import com.rgabay.API_VERSION
import com.rgabay.model.Person
import com.rgabay.model.Request
import com.rgabay.repository.Repository
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post

const val CLEAR_ALL_ENDPOINT = "$API_VERSION/removeall"

fun Route.removeall(db: Repository){

    get(CLEAR_ALL_ENDPOINT){
        val result = db.removeAll()
        call.respond(result)
    }
}