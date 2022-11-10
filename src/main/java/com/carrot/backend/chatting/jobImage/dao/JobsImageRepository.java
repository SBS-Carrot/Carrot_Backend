package com.carrot.backend.chatting.jobImage.dao;

import com.carrot.backend.chatting.jobImage.domain.JobsImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsImageRepository extends JpaRepository<JobsImages, Integer> {
}
