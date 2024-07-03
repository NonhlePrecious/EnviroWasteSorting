package com.enviro.assessment.grad001.nonhlemavimbela;

import com.enviro.assessment.grad001.nonhlemavimbela.model.WasteCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WasteManagementTests {


    private WasteCategory getMockCategory(){
        return new WasteCategory(MockWasteCategory2.categoryId, MockWasteCategory2.type,MockWasteCategory2.name);
    }
    /**
     * test and asserts that the Category has the same values.
     */

    @Test

    public void testCategory(){
        WasteCategory category = null;
        category = getMockCategory();
        Assertions.assertThat(MockWasteCategory2.categoryId).isEqualTo(category.getId());
        Assertions.assertThat(MockWasteCategory2.name).isEqualTo(category.getName());
        Assertions.assertThat(MockWasteCategory2.type).isEqualTo(category.getType());

    }
}
