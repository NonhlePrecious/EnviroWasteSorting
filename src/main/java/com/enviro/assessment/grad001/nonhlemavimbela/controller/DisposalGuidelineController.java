package com.enviro.assessment.grad001.nonhlemavimbela.controller;

import com.enviro.assessment.grad001.nonhlemavimbela.service.DisposalGuidelineService;
import com.enviro.assessment.grad001.nonhlemavimbela.model.DisposalGuideline;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return disposalGuidelineService.getAllGuidelines();
    }

    @GetMapping("/{id}")
    public DisposalGuideline getGuidelineById(@PathVariable Long id) {
        return disposalGuidelineService.getGuidelineById(id);
    }

    @GetMapping("/waste-type/{wasteType}")
    public DisposalGuideline getGuidelineByWasteType(@PathVariable String wasteType) {
        return disposalGuidelineService.getGuidelineByWasteType(wasteType);
    }

    @PostMapping
    public DisposalGuideline createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        return disposalGuidelineService.saveGuideline(guideline);
    }

    @PutMapping("/{id}")
    public DisposalGuideline updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline guideline) {
        return disposalGuidelineService.updateGuideline(id, guideline);
    }

    @DeleteMapping("/{id}")
    public void deleteGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteGuideline(id);
    }
}
