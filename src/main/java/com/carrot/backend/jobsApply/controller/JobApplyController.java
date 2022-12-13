package com.carrot.backend.jobsApply.controller;

import com.carrot.backend.jobs.dao.JobsRepository;
import com.carrot.backend.jobs.domain.Jobs;
import com.carrot.backend.jobsApply.dao.JobsApplyRepository;
import com.carrot.backend.jobsApply.domain.JobsApply;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobApplyController {
    private final JobsApplyRepository jobsApplyRepository;

    private final JobsRepository jobsRepository;

    @GetMapping("/getJobApply")
    public List<JobsApply> getJobsApply (@RequestParam("num") Integer num){
        Jobs jobs = jobsRepository.findById(num).get();
        List<JobsApply> jobsApplies = jobsApplyRepository.findAllByJobs(jobs);


        return jobsApplies;
    }

}
