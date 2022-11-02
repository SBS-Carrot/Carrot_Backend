package com.carrot.backend.jobs.service;

import com.carrot.backend.jobs.dao.JobsRepository;
import com.carrot.backend.jobs.domain.Jobs;
import com.carrot.backend.jobs.dto.JobsDto;
import com.carrot.backend.util.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class JobsService {

   private final JobsRepository jobsRepository;

   public List<Jobs> getJobs(){
      return jobsRepository.findAll();
   }

   public Jobs getJob(Integer jobsId){
      return jobsRepository.findById(jobsId).orElseThrow(() -> new DataNotFoundException("job not found"));
   }

   public Integer createJobs(JobsDto jobsDto){
      Jobs newJobs = new Jobs();

      newJobs.setJobName(jobsDto.getJobName());
      newJobs.setJobCheck(0);
      newJobs.setJobContent(jobsDto.getJobContent());
      newJobs.setJobDay(jobsDto.getJobDay());
      newJobs.setJobLike(0);
      newJobs.setJobPlace(jobsDto.getJobPlace());
      newJobs.setJobPrice(jobsDto.getJobPrice());
      newJobs.setJobSubject(jobsDto.getJobSubject());
      newJobs.setJobStartTime(jobsDto.getJobStartTime());
      newJobs.setJobEndTime(jobsDto.getJobEndTime());
      newJobs.setJobVolunteer(0);
      newJobs.setJobCategory(jobsDto.getJobCategory());
      newJobs.setCreateDate(LocalDateTime.now());
      newJobs.setJobUserid("user");
      jobsRepository.save(newJobs);

      return newJobs.getJobid();
   }


}
