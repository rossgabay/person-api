package com.rgabay.api

import com.rgabay.API_VERSION
import com.rgabay.repository.Repository
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get

const val LIST_ALL_ENDPOINT = "$API_VERSION/listall"

fun Route.listall(db: Repository){

    get(LIST_ALL_ENDPOINT){
        val result = db.listAll()
        call.respond(result.toArray())
    }
}