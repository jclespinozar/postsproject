package com.example.posts.services

import com.example.posts.models.Category
import com.example.posts.models.CategoryDTO
import com.example.posts.models.PostDTO
import com.example.posts.repositories.CategoryRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class CategoryServiceImpl(private val categoryRepository: CategoryRepository) : CategoryService{

    override fun createCategory(categoryDTO: CategoryDTO): CategoryDTO {
        val newCategory = Category(
            name = categoryDTO.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        );
        categoryRepository.save(newCategory);
        return CategoryDTO(
            name = newCategory.name,
            createdAt = newCategory.createdAt,
            updatedAt = newCategory.updatedAt,
        )
    }

    override fun getCategoryById(id: Long): CategoryDTO {
        val category = categoryRepository.findById(id).orElseThrow { RuntimeException("Category not found") }
        return CategoryDTO(
            name = category.name,
            createdAt = category.createdAt,
            updatedAt = category.updatedAt,
        )
    }

    override fun updateCategory(id: Long, categoryDTO: CategoryDTO): CategoryDTO {
        val existingCategory = categoryRepository.findById(id).orElseThrow { RuntimeException("Category not found") }
        val updatedCategory = existingCategory.copy(
            name = categoryDTO.name
        )
        val saveCategory = categoryRepository.save(updatedCategory)
        return CategoryDTO(
            name = saveCategory.name,
            createdAt = saveCategory.createdAt,
            updatedAt = saveCategory.updatedAt,
        )
    }

    override fun deleteCategory(id: Long) {
        val category = categoryRepository.findById(id).orElseThrow { RuntimeException("Category not found") }
        categoryRepository.delete(category)
    }

    override fun getAllCategories(): List<CategoryDTO> {
        val categories = categoryRepository.findAll()
        return categories.map { category ->
            CategoryDTO(
                name = category.name,
                createdAt = category.createdAt,
                updatedAt = category.updatedAt,
            )
        }
    }
}
