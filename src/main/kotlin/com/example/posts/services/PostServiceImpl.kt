package com.example.posts.services

import com.example.posts.models.CommentDTO
import com.example.posts.models.Post
import com.example.posts.models.PostDTO
import com.example.posts.repositories.CategoryRepository
import com.example.posts.repositories.CommentRepository
import com.example.posts.repositories.PostRepository
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val postRepository: PostRepository,
    private val categoryRepository: CategoryRepository
) : PostService {

    override fun createPost(postDTO: PostDTO): PostDTO {
        val newPost = Post(
            title = postDTO.title,
            content = postDTO.content,
            createdAt = postDTO.createdAt,
            updatedAt = postDTO.updatedAt,
            category = categoryRepository.findById(postDTO.categoryId).orElseThrow { RuntimeException("Post not found") }
        )
        postRepository.save(newPost);
        return PostDTO(
            title = newPost.title,
            content = newPost.content,
            createdAt = newPost.createdAt,
            updatedAt = newPost.updatedAt,
            categoryId = newPost.category.id
        )
    }

    override fun getPostById(id: Long): PostDTO {
        val post = postRepository.findById(id).orElseThrow { RuntimeException("Post not found") };
        return PostDTO(
            title = post.title,
            content = post.content,
            createdAt = post.createdAt,
            updatedAt = post.updatedAt,
            categoryId = post.category.id
        )
    }

    override fun updatePost(id: Long, postDTO: PostDTO): PostDTO {
        val existingPost = postRepository.findById(id).orElseThrow { RuntimeException("Post not found") };
        val updatedPost = existingPost.copy(
                title = postDTO.title,
                content = postDTO.content,
        )
        val savePost = postRepository.save(updatedPost);
        return PostDTO(
            title = savePost.title,
            content = savePost.content,
            createdAt = savePost.createdAt,
            updatedAt = savePost.updatedAt,
            categoryId = savePost.category.id
        )
    }

    override fun deletePost(id: Long) {
        val post = postRepository.findById(id).orElseThrow { RuntimeException("Post not found") };
        postRepository.delete(post)
    }

    override fun getAllPosts(): List<PostDTO> {
        val posts = postRepository.findAll()
        return posts.map { post ->
            PostDTO(
                title = post.title,
                content = post.content,
                createdAt = post.createdAt,
                updatedAt = post.updatedAt,
                categoryId = post.category.id
            )
        }
    }
}
