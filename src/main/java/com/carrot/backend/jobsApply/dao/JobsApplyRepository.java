package com.carrot.backend.jobsApply.dao;

import com.carrot.backend.jobsApply.domain.JobsApply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsApplyRepository extends JpaRepository <JobsApply, Integer> {
}
