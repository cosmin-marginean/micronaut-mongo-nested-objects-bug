package com.test

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

@MicronautTest(transactional = false)
class BugTest {

    @Inject
    lateinit var simpleDocRepo: SimpleDocRepository

    @Inject
    lateinit var nestedDocRepo: NestedDocRepository

    @Test
    fun test() {
        // Just to make sure that the write works otherwise with a simple doc
        val simpleDoc = SimpleDoc("John", "Smith")
        simpleDocRepo.save(simpleDoc)
        log.info("Simple doc: " + simpleDocRepo.findById(simpleDoc.id).get())

        val nestedDoc = NestedDoc()
        nestedDocRepo.save(nestedDoc)
        log.info("Nested doc: " + nestedDocRepo.findById(nestedDoc.id).get())
    }

    companion object {
        private val log = LoggerFactory.getLogger(Test::class.java)
    }
}