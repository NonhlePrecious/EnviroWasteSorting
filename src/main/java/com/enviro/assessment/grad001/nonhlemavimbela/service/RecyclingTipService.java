package com.enviro.assessment.grad001.nonhlemavimbela.service;

import com.enviro.assessment.grad001.nonhlemavimbela.model.RecyclingTip;
import com.enviro.assessment.grad001.nonhlemavimbela.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.nonhlemavimbela.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    public List<RecyclingTip> getAllTips() {
        // Fetch tips from static map
        List<RecyclingTip> staticTips = RecyclingTip.getAllStaticTips();

        // Fetch tips from database
        List<RecyclingTip> dbTips = repository.findAll();

        // Combine both lists
        staticTips.addAll(dbTips);

        return staticTips;
    }

    public RecyclingTip getTipById(Long id) {
        if (id > 0) { // Check if the ID is from static tips
            return RecyclingTip.getAllStaticTips().stream()
                    .filter(tip -> tip.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new ResourceNotFoundException("Recycling tip not found"));
        }

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recycling tip not found"));
    }

    public RecyclingTip saveTip(RecyclingTip tip) {
        return repository.save(tip);
    }

    public RecyclingTip updateTip(Long id, RecyclingTip tip) {
        RecyclingTip existingTip = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recycling tip not found"));
        existingTip.setWasteType(tip.getWasteType());
        existingTip.setTip(tip.getTip());
        return repository.save(existingTip);
    }

    public void deleteTip(Long id) {
        repository.deleteById(id);
    }

    public RecyclingTip getTipByWasteType(String wasteType) {
        // First, check the static tips
        String tipText = RecyclingTip.getStaticTip(wasteType);
        if (tipText != null) {
            RecyclingTip tip = new RecyclingTip();
            tip.setWasteType(wasteType);
            tip.setTip(tipText);
            return tip;
        }

        // If not found, check the database
        List<RecyclingTip> tips = repository.findAll();
        return tips.stream()
                .filter(t -> t.getWasteType().equalsIgnoreCase(wasteType))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Recycling tip not found for waste type: " + wasteType));
    }
}
