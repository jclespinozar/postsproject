package com.example.posts.services

import com.example.posts.models.Category
import com.example.posts.models.CategoryDTO

interface CategoryService {
    fun createCategory(categoryDTO: CategoryDTO): CategoryDTO
    fun getCategoryById(id: Long): CategoryDTO
    fun updateCategory(id: Long, categoryDTO: CategoryDTO): CategoryDTO
    fun deleteCategory(id: Long)
    fun getAllCategories(): List<CategoryDTO>
}