package com.test

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable
import java.util.*

@Serdeable
@MappedEntity
data class NestedDoc(
    val child: Child = Child(),

    @field:Id
    val id: String = UUID.randomUUID().toString()
)

@Serdeable
data class Child(
    val name: String = UUID.randomUUID().toString(),
)

