package com.example.posts.services

import com.example.posts.models.CategoryDTO
import com.example.posts.models.Comment
import com.example.posts.models.CommentDTO
import com.example.posts.repositories.CommentRepository
import com.example.posts.repositories.PostRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository
) : CommentService {
    override fun createComment(commentDTO: CommentDTO): CommentDTO {
        val newComment = Comment(
            content = commentDTO.content,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
            post = postRepository.findById(commentDTO.postId).orElseThrow { RuntimeException("Post not found") }
        );
        commentRepository.save(newComment)
        return CommentDTO(
            content = newComment.content,
            createdAt = newComment.createdAt,
            updatedAt = newComment.updatedAt,
            postId = newComment.post.id
        )
    }

    override fun getCommentById(id: Long): CommentDTO {
        val comment = commentRepository.findById(id).orElseThrow { RuntimeException("Comment not found") }
        return CommentDTO(
            content = comment.content,
            createdAt = comment.createdAt,
            updatedAt = comment.updatedAt,
            postId = comment.post.id
        )
    }

    override fun updateComment(id: Long, commentDTO: CommentDTO): CommentDTO {
        val existingComment = commentRepository.findById(id).orElseThrow { RuntimeException("Comment not found") }
        val updatedComment = existingComment.copy(
                content = commentDTO.content
        )
        val saveComment = commentRepository.save(updatedComment);
        return CommentDTO(
            content = saveComment.content,
            createdAt = saveComment.createdAt,
            updatedAt = saveComment.updatedAt,
            postId = saveComment.id
        )
    }

    override fun deleteComment(id: Long) {
        val comment = commentRepository.findById(id).orElseThrow { RuntimeException("Comment not found") }
        commentRepository.delete(comment)
    }

    override fun getAllComments(): List<CommentDTO> {
        val comments = commentRepository.findAll()
        return comments.map { comment ->
            CommentDTO(
                content = comment.content,
                createdAt = comment.createdAt,
                updatedAt = comment.updatedAt,
                postId = comment.id
            )
        }
    }
}
