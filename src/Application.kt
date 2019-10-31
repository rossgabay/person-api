package com.rgabay

import com.rgabay.api.addperson
import com.rgabay.api.listall
import com.rgabay.api.removeall
import com.rgabay.repository.InMemoryImpl
import io.ktor.application.*
import io.ktor.routing.routing
import com.rgabay.routes.*
import com.ryanharter.ktor.moshi.moshi
import freemarker.cache.ClassTemplateLoader
import io.ktor.features.ContentNegotiation
import io.ktor.freemarker.FreeMarker


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(io.ktor.features.DefaultHeaders)
    //TODO - install StatusPages
    install(ContentNegotiation){
       moshi()
    }
    install(FreeMarker){
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }
    routing{
        home()
        about()

        addperson(db)
        removeall(db)
        listall(db)
    }
}

const val API_VERSION = "/api/v1"
val db = InMemoryImpl()