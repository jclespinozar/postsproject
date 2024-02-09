package com.example.posts.models

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "comentario")
data class Comment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_id", nullable = false)
        @JsonBackReference
        val post: Post,

        @Column(name = "contenido", nullable = false, length = 500)
        val content: String,

        @Column(name = "fecha_creacion", nullable = false)
        @CreationTimestamp
        val createdAt: Instant,

        @Column(name = "fecha_actualizacion", nullable = false)
        @UpdateTimestamp
        val updatedAt: Instant,
)
