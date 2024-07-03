package com.enviro.assessment.grad001.nonhlemavimbela.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Waste type is mandatory")
    private String wasteType;

    @NotEmpty(message = "Guideline is mandatory")
    private String guideline;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    private static final Map<String, String> guidelines = new HashMap<>();

    static {
        guidelines.put("food", "Compost or dispose of in the green waste bin.");
        guidelines.put("yard", "Compost or dispose of in the green waste bin.");
        guidelines.put("plastic", "Clean and place in the recycling bin.");
        guidelines.put("metal", "Clean and place in the recycling bin.");
        guidelines.put("paper", "Place in the recycling bin.");
        guidelines.put("glass", "Clean and place in the recycling bin.");
        guidelines.put("chemical", "Dispose of at a hazardous waste facility.");
        guidelines.put("electronical", "Take to an e-waste recycling center.");
        guidelines.put("medical", "Dispose of in a medical waste container.");
    }

    public static String getStaticGuideline(String wasteType) {
        return guidelines.getOrDefault(wasteType, null);
    }

    public static List<DisposalGuideline> getAllStaticGuidelines() {
        List<DisposalGuideline> staticGuidelines = new ArrayList<>();
        long staticId = 1;
        for (Map.Entry<String, String> entry : guidelines.entrySet()) {
            DisposalGuideline guideline = new DisposalGuideline();
            guideline.setId(staticId++);
            guideline.setWasteType(entry.getKey());
            guideline.setGuideline(entry.getValue());
            staticGuidelines.add(guideline);
        }
        return staticGuidelines;
    }
}
