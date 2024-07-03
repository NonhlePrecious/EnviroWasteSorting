package com.enviro365.enviro.model;

import jakarta.persistence.*;

/**
 * The persistent WasteCategory class that contains information about a waste category.
 */
@Entity
@Table(name = "WASTE_MANAGEMENT")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_gen")
    @SequenceGenerator(name = "category_id_gen", sequenceName = "category_id_seq_pg", allocationSize = 1)
    @Column(name = "CATEGORY_ID", unique = true)
    private Long categoryId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DISPOSAL_GUIDELINES")
    private String disposalGuidelines;

    @Column(name = "RECYCLING_TIPS")
    private String recyclingTips;

    public WasteCategory() {}

    public WasteCategory(Long id, String name, String disposalGuidelines, String recyclingTips) {
        this.categoryId = id;
        this.name = name;
        this.disposalGuidelines = disposalGuidelines;
        this.recyclingTips = recyclingTips;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisposalGuidelines() {
        return disposalGuidelines;
    }

    public void setDisposalGuidelines(String disposalGuidelines) {
        this.disposalGuidelines = disposalGuidelines;
    }

    public String getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(String recyclingTips) {
        this.recyclingTips = recyclingTips;
    }

    @Override
    public String toString() {
        return "WasteCategory{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", disposalGuidelines='" + disposalGuidelines + '\'' +
                ", recyclingTips='" + recyclingTips + '\'' +
                '}';
    }
}
