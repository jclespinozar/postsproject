package com.example.posts.controllers

import com.example.posts.models.Comment
import com.example.posts.models.CommentDTO
import com.example.posts.services.CommentServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController(private val commentServiceImpl: CommentServiceImpl) {

    @PostMapping
    fun createComment(@RequestBody commentDTO: CommentDTO): ResponseEntity<CommentDTO> {
        val savedComment = commentServiceImpl.createComment(commentDTO)
        return ResponseEntity.ok(savedComment)
    }

    @GetMapping("/{id}")
    fun getComment(@PathVariable id: Long): ResponseEntity<CommentDTO> {
        val comment = commentServiceImpl.getCommentById(id)
        return ResponseEntity.ok(comment)
    }

    @PutMapping("/{id}")
    fun updateComment(@PathVariable id: Long, @RequestBody commentDTO: CommentDTO): ResponseEntity<CommentDTO> {
        val updatedComment = commentServiceImpl.updateComment(id, commentDTO)
        return ResponseEntity.ok(updatedComment)
    }

    @DeleteMapping("/{id}")
    fun deleteComment(@PathVariable id: Long): ResponseEntity<Void> {
        commentServiceImpl.deleteComment(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAllComments(): ResponseEntity<List<CommentDTO>> {
        val comments = commentServiceImpl.getAllComments()
        return ResponseEntity.ok(comments)
    }
}
