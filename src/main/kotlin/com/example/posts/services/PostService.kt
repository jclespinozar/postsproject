package com.example.posts.services

import com.example.posts.models.Post
import com.example.posts.models.PostDTO

interface PostService {
    fun createPost(postDTO: PostDTO): PostDTO
    fun getPostById(id: Long): PostDTO
    fun updatePost(id: Long, postDTO: PostDTO): PostDTO
    fun deletePost(id: Long)
    fun getAllPosts(): List<PostDTO>
}