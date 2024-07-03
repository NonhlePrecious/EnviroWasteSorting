package com.enviro365.enviro.config;

import com.enviro365.enviro.model.WasteCategory;
import com.enviro365.enviro.repository.WasteCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(WasteCategoryRepository repository) {
        return new DatabaseInitializer(repository);
    }

    static class DatabaseInitializer implements CommandLineRunner {
        private final WasteCategoryRepository repository;

        DatabaseInitializer(WasteCategoryRepository repository) {
            this.repository = repository;
        }

        @Override
        public void run(String... args) throws Exception {
            repository.save(new WasteCategory(1L, "Plastic", "Recycle at designated centers", "Rinse and clean before recycling"));
            repository.save(new WasteCategory(2L, "Glass", "Recycle at designated centers", "Remove lids and rinse before recycling"));
            repository.save(new WasteCategory(3L, "Paper", "Recycle at designated centers", "Keep dry and free from food residue"));
            repository.save(new WasteCategory(4L, "Metal", "Recycle at designated centers", "Remove labels and rinse before recycling"));
            repository.save(new WasteCategory(5L, "Organic", "Compost at home or designated facilities", "Separate food waste from other waste"));
        }
    }
}