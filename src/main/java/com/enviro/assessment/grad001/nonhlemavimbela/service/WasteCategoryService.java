package com.enviro.assessment.grad001.nonhlemavimbela.service;

import com.enviro.assessment.grad001.nonhlemavimbela.model.WasteCategory;
import com.enviro.assessment.grad001.nonhlemavimbela.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.nonhlemavimbela.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.nonhlemavimbela.model.WasteCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    public WasteCategoryResponse getAllCategories() {
        return WasteCategory.getStaticWasteCategoryResponse();
    }

    public WasteCategory getCategoryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));
    }

    public WasteCategory getCategoryByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Waste category not found with name: " + name));
    }

    public WasteCategory saveCategory(WasteCategory category) {
        return repository.save(category);
    }

    public WasteCategory updateCategory(Long id, WasteCategory category) {
        WasteCategory existingCategory = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));
        existingCategory.setType(category.getType());
        existingCategory.setName(category.getName());
        return repository.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
