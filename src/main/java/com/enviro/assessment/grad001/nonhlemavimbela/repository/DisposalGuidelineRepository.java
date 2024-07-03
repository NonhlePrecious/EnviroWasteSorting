package com.enviro.assessment.grad001.nonhlemavimbela.repository;

import com.enviro.assessment.grad001.nonhlemavimbela.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
}
