package com.enviro.assessment.grad001.nonhlemavimbela.service;

import com.enviro.assessment.grad001.nonhlemavimbela.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.nonhlemavimbela.model.DisposalGuideline;
import com.enviro.assessment.grad001.nonhlemavimbela.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    public List<DisposalGuideline> getAllGuidelines() {
        // Fetch guidelines from static map
        List<DisposalGuideline> staticGuidelines = DisposalGuideline.getAllStaticGuidelines();

        // Fetch guidelines from database
        List<DisposalGuideline> dbGuidelines = repository.findAll();

        // Combine both lists
        staticGuidelines.addAll(dbGuidelines);

        return staticGuidelines;
    }

    public DisposalGuideline getGuidelineById(Long id) {
        if (id > 0) { // Check if the ID is from static guidelines
            return DisposalGuideline.getAllStaticGuidelines().stream()
                    .filter(guideline -> guideline.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new ResourceNotFoundException("Disposal guideline not found"));
        }

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal guideline not found"));
    }

    public DisposalGuideline saveGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    public DisposalGuideline updateGuideline(Long id, DisposalGuideline guideline) {
        DisposalGuideline existingGuideline = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal guideline not found"));
        existingGuideline.setWasteType(guideline.getWasteType());
        existingGuideline.setGuideline(guideline.getGuideline());
        return repository.save(existingGuideline);
    }

    public void deleteGuideline(Long id) {
        repository.deleteById(id);
    }

    public DisposalGuideline getGuidelineByWasteType(String wasteType) {
        // First, check the static guidelines
        String guidelineText = DisposalGuideline.getStaticGuideline(wasteType);
        if (guidelineText != null) {
            DisposalGuideline guideline = new DisposalGuideline();
            guideline.setWasteType(wasteType);
            guideline.setGuideline(guidelineText);
            return guideline;
        }

        // If not found, check the database
        List<DisposalGuideline> guidelines = repository.findAll();
        return guidelines.stream()
                .filter(g -> g.getWasteType().equalsIgnoreCase(wasteType))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Disposal guideline not found for waste type: " + wasteType));
    }
}
