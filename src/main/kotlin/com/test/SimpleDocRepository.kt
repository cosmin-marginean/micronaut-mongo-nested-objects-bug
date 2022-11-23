package com.test

import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.PageableRepository

@MongoRepository
interface SimpleDocRepository : PageableRepository<SimpleDoc, String>