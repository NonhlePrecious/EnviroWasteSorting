package com.enviro.assessment.grad001.nonhlemavimbela.repository;

import com.enviro.assessment.grad001.nonhlemavimbela.model.WasteCategory;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    Optional<WasteCategory> findById(Long id);
    Optional<WasteCategory> findByName(String name);

//    List<WasteCategory> findByName(String name);

    WasteCategory save(WasteCategory existingCategory);

    void deleteById(Long id);

    List<WasteCategory> findAll();
}
