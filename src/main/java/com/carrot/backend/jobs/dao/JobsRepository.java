package com.carrot.backend.jobs.dao;

import com.carrot.backend.jobs.domain.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobsRepository extends JpaRepository<Jobs, Integer>,CustomizedJobsRepository {
    Optional<Jobs> findByJobid(Integer jobid);

    List<Jobs> findByJobPlaceContaining(String search);
}
