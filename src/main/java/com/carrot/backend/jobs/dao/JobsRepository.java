package com.carrot.backend.jobs.dao;

import com.carrot.backend.jobs.domain.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, Integer>,CustomizedJobsRepository {

}
