package com.carrot.backend.jobsApply.dao;

import com.carrot.backend.jobs.domain.Jobs;
import com.carrot.backend.jobsApply.domain.JobsApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobsApplyRepository extends JpaRepository <JobsApply, Integer> {
    List<JobsApply> findAllByJobs(Jobs jobs);
}
