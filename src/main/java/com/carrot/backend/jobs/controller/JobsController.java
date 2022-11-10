package com.carrot.backend.jobs.controller;

import com.carrot.backend.chatting.jobImage.service.JobsImageService;
import com.carrot.backend.jobs.domain.Jobs;
import com.carrot.backend.jobs.dto.JobsDto;
import com.carrot.backend.jobs.service.JobsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class JobsController {

    private final JobsService jobsService;
    private final JobsImageService jobsImageService;
    @GetMapping("/jobs")
    public List<Jobs> getJobs(){
        return jobsService.getJobs();
    }

    @GetMapping("/Jobs/{jobsId}")
    public Jobs getJob(@PathVariable Integer jobsId){
        return jobsService.getJob(jobsId);
    }

    @PostMapping("/createJobs")
    public Jobs createJobs(@RequestBody JobsDto jobsDto){
        Integer id = jobsService.createJobs(jobsDto);
        return jobsService.getJob(id);
    }
    @PostMapping("createJobsImages")
    public Jobs createJobsImg(@RequestPart(value = "jobDto") JobsDto jobsDto, @RequestPart("file") List<MultipartFile> multipartFile) throws IOException{
        Integer id = jobsService.createJobs(jobsDto);
        jobsImageService.uploads(id, multipartFile, "jobsImages");
        return jobsService.getJob(id);
    }

    //조회수 올리는 메소드

}
