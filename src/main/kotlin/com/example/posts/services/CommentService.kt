package com.example.posts.services

import com.example.posts.models.Comment
import com.example.posts.models.CommentDTO

interface CommentService {
    fun createComment(commentDTO: CommentDTO): CommentDTO
    fun getCommentById(id: Long): CommentDTO
    fun updateComment(id: Long, commentDTO: CommentDTO): CommentDTO
    fun deleteComment(id: Long)
    fun getAllComments(): List<CommentDTO>
}