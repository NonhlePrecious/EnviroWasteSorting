package com.enviro365.enviro;

import com.enviro365.enviro.model.WasteCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WasteManagementTests {


    private WasteCategory getMockCategory(){
        return new WasteCategory(MockWasteCategory.categoryId, MockWasteCategory.name,
                MockWasteCategory.disposalGuidelines,MockWasteCategory.recyclingTips);
    }
    /**
     * test and asserts that the Category has the same values.
     */

    @Test

    public void testCategory(){
        WasteCategory category = null;
        category = getMockCategory();
        Assertions.assertThat(MockWasteCategory.categoryId).isEqualTo(category.getCategoryId());
        Assertions.assertThat(MockWasteCategory.name).isEqualTo(category.getName());
        Assertions.assertThat(MockWasteCategory.disposalGuidelines).isEqualTo(category.getDisposalGuidelines());
        Assertions.assertThat(MockWasteCategory.recyclingTips).isEqualTo(category.getRecyclingTips());

    }
}
