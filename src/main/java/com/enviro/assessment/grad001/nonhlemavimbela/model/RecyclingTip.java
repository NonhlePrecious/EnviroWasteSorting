package com.enviro.assessment.grad001.nonhlemavimbela.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Waste type is mandatory")
    private String wasteType;

    @NotBlank(message = "Tip is mandatory")
    private String tip;

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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    private static final Map<String, String> tips = new HashMap<>();

    static {
        tips.put("plastic", "Reduce plastic use and clean before recycling.");
        tips.put("metal", "Rinse metal containers before recycling.");
        tips.put("paper", "Avoid recycling wet or greasy paper.");
        tips.put("glass", "Separate glass by color if required by local facility.");
    }

    public static String getStaticTip(String wasteType) {
        return tips.getOrDefault(wasteType, "No recycling tips available for this waste type.");
    }

    public static List<RecyclingTip> getAllStaticTips() {
        List<RecyclingTip> staticTips = new ArrayList<>();
        long staticId = 1;
        for (Map.Entry<String, String> entry : tips.entrySet()) {
            RecyclingTip tip = new RecyclingTip();
            tip.setId(staticId++); // Assign negative IDs to static tips
            tip.setWasteType(entry.getKey());
            tip.setTip(entry.getValue());
            staticTips.add(tip);
        }
        return staticTips;
    }
}
