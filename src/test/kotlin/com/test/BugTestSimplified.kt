package com.test

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test

@MicronautTest
class BugTestSimplified {

    @Inject
    lateinit var nestedDocRepo: NestedDocRepository

    @Test
    fun test() {
        val nestedDoc = NestedDoc()
        nestedDocRepo.save(nestedDoc)
        println("Nested doc: " + nestedDocRepo.findById(nestedDoc.id).get())
    }
}