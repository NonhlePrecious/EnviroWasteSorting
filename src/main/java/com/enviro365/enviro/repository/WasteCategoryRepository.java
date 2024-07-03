package com.enviro365.enviro.repository;

import com.enviro365.enviro.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    Optional<WasteCategory> findByNameContainingIgnoreCase(String name);

    List<WasteCategory> findAll();
}
