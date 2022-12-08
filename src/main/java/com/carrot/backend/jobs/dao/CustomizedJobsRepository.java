package com.carrot.backend.jobs.dao;

import com.carrot.backend.jobs.dto.JobsDto;

public interface CustomizedJobsRepository {

    JobsDto getQslJobsAndImagesByJobId(Integer jobsId);
}
