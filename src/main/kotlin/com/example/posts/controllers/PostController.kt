package com.example.posts.controllers

import com.example.posts.models.Post
import com.example.posts.services.PostServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(private val postServiceImpl: PostServiceImpl) {

    @PostMapping
    fun createPost(@RequestBody post: Post): ResponseEntity<Post> {
        val savedPost = postServiceImpl.createPost(post)
        return ResponseEntity.ok(savedPost)
    }

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: Long): ResponseEntity<Post> {
        val post = postServiceImpl.getPostById(id)
        return ResponseEntity.ok(post)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody post: Post): ResponseEntity<Post> {
        val updatedPost = postServiceImpl.updatePost(id, post)
        return ResponseEntity.ok(updatedPost)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Void> {
        postServiceImpl.deletePost(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAllPosts(): ResponseEntity<List<Post>> {
        val posts = postServiceImpl.getAllPosts()
        return ResponseEntity.ok(posts)
    }
}
