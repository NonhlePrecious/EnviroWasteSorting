package com.enviro.assessment.grad001.nonhlemavimbela.config;

import com.enviro.assessment.grad001.nonhlemavimbela.model.WasteCategory;
import com.enviro.assessment.grad001.nonhlemavimbela.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.nonhlemavimbela.model.DisposalGuideline;
import com.enviro.assessment.grad001.nonhlemavimbela.model.RecyclingTip;
import com.enviro.assessment.grad001.nonhlemavimbela.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.nonhlemavimbela.repository.RecyclingTipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(WasteCategoryRepository wasteCategoryRepository,
                                   RecyclingTipRepository recyclingTipRepository,
                                   DisposalGuidelineRepository disposalGuidelineRepository) {
        return args -> {
            // Initialize Waste Categories
            List<WasteCategory> staticWasteCategories = WasteCategory.getAllStaticCategories();
            staticWasteCategories.forEach(category -> wasteCategoryRepository.save(category));

            // Initialize Recycling Tips
            List<RecyclingTip> staticRecyclingTips = RecyclingTip.getAllStaticTips();
            staticRecyclingTips.forEach(tip -> recyclingTipRepository.save(tip));

            // Initialize Disposal Guidelines
            List<DisposalGuideline> staticDisposalGuidelines = DisposalGuideline.getAllStaticGuidelines();
            staticDisposalGuidelines.forEach(guideline -> disposalGuidelineRepository.save(guideline));
        };
    }
}
