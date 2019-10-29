package com.rgabay.repository

import com.rgabay.model.Person

interface Repository {
    suspend fun add(person: Person):Person
    suspend fun listAll():List<Person>
    //suspend fun remove(id:Int):Boolean
    suspend fun removeAll():Boolean
}