package com.example.posts.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class PostDTO(
    @JsonProperty("titulo")
    val title: String,
    @JsonProperty("contenido")
    val content: String,
    @JsonProperty("fecha_creacion")
    val createdAt: Instant,
    @JsonProperty("fecha_actualizacion")
    val updatedAt: Instant,
    @JsonIgnore
    val categoryId: Long
)