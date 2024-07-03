package com.enviro.assessment.grad001.nonhlemavimbela.controller;

import com.enviro.assessment.grad001.nonhlemavimbela.model.RecyclingTip;
import com.enviro.assessment.grad001.nonhlemavimbela.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return recyclingTipService.getAllTips();
    }

    @GetMapping("/{id}")
    public RecyclingTip getTipById(@PathVariable Long id) {
        return recyclingTipService.getTipById(id);
    }

    @GetMapping("/waste-type/{wasteType}")
    public RecyclingTip getTipByWasteType(@PathVariable String wasteType) {
        return recyclingTipService.getTipByWasteType(wasteType);
    }

    @PostMapping
    public RecyclingTip createTip(@Valid @RequestBody RecyclingTip tip) {
        return recyclingTipService.saveTip(tip);
    }

    @PutMapping("/{id}")
    public RecyclingTip updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tip) {
        return recyclingTipService.updateTip(id, tip);
    }

    @DeleteMapping("/{id}")
    public void deleteTip(@PathVariable Long id) {
        recyclingTipService.deleteTip(id);
    }
}
