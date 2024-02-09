package com.example.posts.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "post")
data class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "categoria_id", nullable = false)
        @JsonBackReference
        val category: Category,

        @Column(name = "titulo", nullable = false, length = 150)
        val title: String,

        @Column(name = "contenido", nullable = false, columnDefinition = "TEXT")
        val content: String,

        @Column(name = "fecha_creacion", nullable = false)
        @CreationTimestamp
        val createdAt: Instant,

        @Column(name = "fecha_actualizacion", nullable = false)
        @UpdateTimestamp
        val updatedAt: Instant,

        @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JsonManagedReference
        val comments: List<Comment> = mutableListOf()
)
