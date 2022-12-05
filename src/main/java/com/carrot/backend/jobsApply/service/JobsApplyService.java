package com.carrot.backend.jobsApply.service;

import com.carrot.backend.jobs.dao.JobsRepository;
import com.carrot.backend.jobs.domain.Jobs;
import com.carrot.backend.jobsApply.dao.JobsApplyRepository;
import com.carrot.backend.jobsApply.domain.JobsApply;
import com.carrot.backend.jobsApply.dto.JobsApplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class JobsApplyService {
    private final JobsApplyRepository jobsApplyRepository;
    private final JobsRepository jobsRepository;

    public boolean apply(Integer jobsId, JobsApplyDto applyJobsDto) {
        try {
            JobsApply jobsApply = new JobsApply();
            Jobs jobs = jobsRepository.findById(jobsId).orElseThrow();
            jobsApply.setJobs(jobs);
            jobsApply.setName(applyJobsDto.getName());
            jobsApply.setGender(applyJobsDto.getGender());
            jobsApply.setPhoneValue(applyJobsDto.getPhoneValue());
            jobsApply.setIntroduce(applyJobsDto.getIntroduce());
            jobsApply.setYear(applyJobsDto.getYear());
            LocalDateTime date = LocalDateTime.now();
            String dates = date.toString();
            String yymmdd = dates.substring(0, 10);
            jobsApply.setApplyDate(yymmdd);
            jobsApplyRepository.save(jobsApply);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
