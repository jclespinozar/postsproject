package com.example.posts.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "categoria")
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "nombre", nullable = false, length = 150)
        val name: String,

        @Column(name = "fecha_creacion", nullable = false)
        @CreationTimestamp
        val createdAt: Instant,

        @Column(name = "fecha_actualizacion", nullable = false)
        @UpdateTimestamp
        val updatedAt: Instant,

        @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JsonManagedReference
        val posts: List<Post> = mutableListOf()
)
