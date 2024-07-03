package com.enviro.assessment.grad001.nonhlemavimbela.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Type is mandatory")
    private String type;

    @NotBlank(message = "Name is mandatory")
    private String name;

    // Getters and setters
    public WasteCategory() {
    }

    public WasteCategory(Long id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public WasteCategory(Long id, String type, String disposal, String recycle) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final Map<String, List<WasteCategory>> categories = new HashMap<>();

    static {
        categories.put("organic", Arrays.asList(
                new WasteCategory(1L, "organic", "food"),
                new WasteCategory(2L, "organic", "yard")
        ));
        categories.put("recyclable", Arrays.asList(
                new WasteCategory(3L, "recyclable", "plastic"),
                new WasteCategory(4L, "recyclable", "metal"),
                new WasteCategory(5L, "recyclable", "paper"),
                new WasteCategory(6L, "recyclable", "glass")
        ));
        categories.put("hazardous", Arrays.asList(
                new WasteCategory(7L, "hazardous", "chemical"),
                new WasteCategory(8L, "hazardous", "electronical"),
                new WasteCategory(9L, "hazardous", "medical")
        ));
    }

    public static List<WasteCategory> getAllStaticCategories() {
        List<WasteCategory> allCategories = new ArrayList<>();
        categories.values().forEach(allCategories::addAll);
        return allCategories;
    }

    public static WasteCategoryResponse getStaticWasteCategoryResponse() {
        return new WasteCategoryResponse(
                new WasteCategoryResponse.WasteType(categories.get("organic")),
                new WasteCategoryResponse.WasteType(categories.get("recyclable")),
                new WasteCategoryResponse.WasteType(categories.get("hazardous"))
        );
    }
}
