package com.enviro.assessment.grad001.nonhlemavimbela.model;

import java.util.List;

public class WasteCategoryResponse {

    private WasteType organic;
    private WasteType recyclable;
    private WasteType hazardous;

    public WasteCategoryResponse(WasteType organic, WasteType recyclable, WasteType hazardous) {
        this.organic = organic;
        this.recyclable = recyclable;
        this.hazardous = hazardous;
    }

    // Getters and setters
    public WasteType getOrganic() {
        return organic;
    }

    public void setOrganic(WasteType organic) {
        this.organic = organic;
    }

    public WasteType getRecyclable() {
        return recyclable;
    }

    public void setRecyclable(WasteType recyclable) {
        this.recyclable = recyclable;
    }

    public WasteType getHazardous() {
        return hazardous;
    }

    public void setHazardous(WasteType hazardous) {
        this.hazardous = hazardous;
    }

    public static class WasteType {

        private List<WasteCategory> items;

        public WasteType(List<WasteCategory> items) {
            this.items = items;
        }

        // Getters and setters
        public List<WasteCategory> getItems() {
            return items;
        }

        public void setItems(List<WasteCategory> items) {
            this.items = items;
        }
    }
}
