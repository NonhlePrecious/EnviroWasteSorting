package com.enviro365.enviro.controller;

import com.enviro365.enviro.model.WasteCategory;
import com.enviro365.enviro.service.WasteCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService service;

    public WasteCategoryController(WasteCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> categories = service.getAllWasteCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/search")
    public ResponseEntity<WasteCategory> searchCategories(@RequestParam String keyword) {
        WasteCategory category = service.getWasteCategoryByName(keyword);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<WasteCategory> getCategoryDetails(@PathVariable Long categoryId) {
        try {
            WasteCategory category = service.getWasteCategoryById(categoryId);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        WasteCategory createdCategory = service.createWasteCategory(wasteCategory);
        return ResponseEntity.ok(createdCategory);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<WasteCategory> updateWasteCategory(
            @PathVariable Long categoryId,
            @RequestBody WasteCategory updateWasteCategory) {
        try {
            WasteCategory updatedCategory = service.updateWasteCategory(categoryId, updateWasteCategory);
            return ResponseEntity.ok(updatedCategory);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long categoryId) {
        try {
            service.deleteWasteCategory(categoryId);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
