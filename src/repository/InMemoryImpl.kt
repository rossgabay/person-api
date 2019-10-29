package com.rgabay.repository

import com.rgabay.model.Person
import java.util.concurrent.atomic.AtomicInteger

class InMemoryImpl : Repository {

    private val currentId = AtomicInteger()
    private val personList = ArrayList<Person>();

    override suspend fun add(person: Person): Person {
        // for now we're allowing dups, for uniqueness - look up person by e.g. name
        // and return instead of adding
        person.id = currentId.incrementAndGet();
        personList.add(person)
        return person
    }

    override suspend fun listAll(): List<Person> {
       return personList.toList()
    }

    override suspend fun removeAll(): Boolean {
         personList.clear()
         currentId.set(0)
         return true
    }
}