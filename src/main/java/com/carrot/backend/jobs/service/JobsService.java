package com.carrot.backend.jobs.service;

import com.carrot.backend.jobs.dao.CustomizedJobsRepositoryImpl;
import com.carrot.backend.jobs.dao.JobsRepository;
import com.carrot.backend.jobs.domain.Jobs;
import com.carrot.backend.jobs.dto.JobsDto;
import com.carrot.backend.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class JobsService {

   private final JobsRepository jobsRepository;
   private final CustomizedJobsRepositoryImpl customizedJobsRepository;

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
      LocalDateTime date = LocalDateTime.now();
      String dates = date.toString();
      String yymmdd = dates.substring(0,10);
      newJobs.setCreateDate(yymmdd);
      newJobs.setJobUserid("user");
      jobsRepository.save(newJobs);

      return newJobs.getJobid();
   }


   public void jobCheck(Integer jobsId) {
      Jobs jobs = jobsRepository.findById(jobsId).orElseThrow(()-> new DataNotFoundException("not found"));

      jobs.setJobCheck(jobs.getJobCheck() +1);
      jobsRepository.save(jobs);
   }

   public JobsDto getJobsWithImage(Integer jobsId) {
         JobsDto jobs = customizedJobsRepository.getQslJobsAndImagesByJobsId(jobsId);
         return jobs;
   }
}
