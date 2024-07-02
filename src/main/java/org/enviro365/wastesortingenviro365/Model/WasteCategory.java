package org.enviro365.wastesortingenviro365.Model;

public class WasteCategory {

    private Long id;
    private String categoryName;

    public WasteCategory(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;

    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
