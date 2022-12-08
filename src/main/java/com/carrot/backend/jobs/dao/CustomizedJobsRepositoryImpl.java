package com.carrot.backend.jobs.dao;

import com.carrot.backend.jobImage.domain.QJobsImages;
import com.carrot.backend.jobs.domain.Jobs;
import com.carrot.backend.jobs.domain.QJobs;
import com.carrot.backend.jobs.dto.JobsDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CustomizedJobsRepositoryImpl implements CustomizedJobsRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public JobsDto getQslJobsAndImagesByJobId(Integer jobsId) {
        Jobs jobs = jpaQueryFactory
                .select(QJobs.jobs)
                .from(QJobs.jobs)
                .innerJoin(QJobsImages.jobsImages)
                .on(QJobs.jobs.jobid.eq(jobsId))
                .fetchOne();

        List<String> imagePaths = new ArrayList<>();
        jobs.getImages().stream().forEach(jobsImage->imagePaths.add(jobsImage.getJobPath()));

        JobsDto jobsDto = JobsDto.builder()
                .jobid(jobs.getJobid())
                .jobCategory(jobs.getJobCategory())
                .jobCheck(jobs.getJobCheck())
                .jobContent(jobs.getJobContent())
                .jobSubject(jobs.getJobSubject())
                .jobStartTime(jobs.getJobStartTime())
                .jobEndTime(jobs.getJobEndTime())
                .jobVolunteer(jobs.getJobVolunteer())
                .jobLike(jobs.getJobLike())
                .jobDay(jobs.getJobDay())
                .jobPrice(jobs.getJobPrice())
                .jobName(jobs.getJobName())
                .createDate(jobs.getCreateDate())
                .jobUserid(jobs.getJobUserid())
                .jobPlace(jobs.getJobPlace())
                .profileImage(jobs.getProfileImage())
                .images(imagePaths)
                .build();

        return jobsDto;
    }


}
