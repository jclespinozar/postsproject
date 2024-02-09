package com.example.posts.models

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class CategoryDTO(
    @JsonProperty("nombre")
    val name: String,
    @JsonProperty("fecha_creacion")
    val createdAt: Instant,
    @JsonProperty("fecha_actualizacion")
    val updatedAt: Instant,
)