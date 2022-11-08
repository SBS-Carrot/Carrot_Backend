package com.carrot.backend.jobs.dao;

import com.carrot.backend.jobs.domain.Jobs;

public interface CustomizedJobsRepository {
    Jobs getQslJobs(Integer id);
}
