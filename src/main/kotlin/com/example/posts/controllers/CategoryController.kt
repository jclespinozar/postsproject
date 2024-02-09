package com.example.posts.controllers

import com.example.posts.models.Category
import com.example.posts.models.CategoryDTO
import com.example.posts.services.CategoryServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
class CategoryController(private val categoryServiceImpl: CategoryServiceImpl) {

    @PostMapping
    fun createCategory(@RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        val savedCategory = categoryServiceImpl.createCategory(categoryDTO)
        return ResponseEntity.ok(savedCategory)
    }

    @GetMapping("/{id}")
    fun getCategory(@PathVariable id: Long): ResponseEntity<CategoryDTO> {
        val category = categoryServiceImpl.getCategoryById(id)
        return ResponseEntity.ok(category)
    }

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody category: CategoryDTO): ResponseEntity<CategoryDTO> {
        val updatedCategory = categoryServiceImpl.updateCategory(id, category)
        return ResponseEntity.ok(updatedCategory)
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long): ResponseEntity<Void> {
        categoryServiceImpl.deleteCategory(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAllCategories(): ResponseEntity<List<CategoryDTO>> {
        val categories = categoryServiceImpl.getAllCategories()
        return ResponseEntity.ok(categories)
    }
}
