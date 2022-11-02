package com.carrot.backend.jobImage.dao;

import com.carrot.backend.jobImage.domain.JobsImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsImageRepository extends JpaRepository<JobsImages, Integer> {
}
