package com.enviro.assessment.grad001.nonhlemavimbela.controller;

import com.enviro.assessment.grad001.nonhlemavimbela.model.WasteCategory;
import com.enviro.assessment.grad001.nonhlemavimbela.service.WasteCategoryService;
import com.enviro.assessment.grad001.nonhlemavimbela.model.WasteCategoryResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @GetMapping
    public WasteCategoryResponse getAllCategories() {
        return wasteCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public WasteCategory getCategoryById(@PathVariable Long id) {
        return wasteCategoryService.getCategoryById(id);
    }

    @GetMapping("/name/{name}")
    public WasteCategory getCategoryByName(@PathVariable String name) {
        return wasteCategoryService.getCategoryByName(name);
    }

    @PostMapping
    public WasteCategory createCategory(@Valid @RequestBody WasteCategory category) {
        return wasteCategoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    public WasteCategory updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory category) {
        return wasteCategoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);
    }
}
