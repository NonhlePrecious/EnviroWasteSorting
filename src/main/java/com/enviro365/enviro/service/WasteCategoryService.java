package com.enviro365.enviro.service;

import com.enviro365.enviro.model.ResourceNotFoundException;
import com.enviro365.enviro.model.WasteCategory;
import com.enviro365.enviro.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {
    private final WasteCategoryRepository repository;

    public WasteCategoryService(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    public List<WasteCategory> getAllWasteCategories() {
        return repository.findAll();
    }

    public WasteCategory getWasteCategoryByName(String name) {
        return repository.findByNameContainingIgnoreCase(name)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category not found with name: " + name));
    }

    public WasteCategory getWasteCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category not found with ID: " + id));
    }

    public WasteCategory createWasteCategory(WasteCategory wasteCategory){
        return repository.save(wasteCategory);
    }

    public WasteCategory updateWasteCategory(Long id, WasteCategory updateWasteCategory){
        WasteCategory wasteCategory = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category not found with ID: " + id));

        wasteCategory.setName(updateWasteCategory.getName());
        wasteCategory.setDisposalGuidelines(updateWasteCategory.getDisposalGuidelines());
        wasteCategory.setRecyclingTips(updateWasteCategory.getRecyclingTips());

        return repository.save(wasteCategory);
    }

    public void deleteWasteCategory(Long id){
        WasteCategory wasteCategory = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Waste category not found with ID: " + id));
        repository.delete(wasteCategory);
    }
}
