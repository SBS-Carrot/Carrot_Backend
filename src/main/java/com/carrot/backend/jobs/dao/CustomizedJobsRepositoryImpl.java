package com.carrot.backend.jobs.dao;

import com.carrot.backend.jobs.domain.Jobs;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomizedJobsRepositoryImpl implements CustomizedJobsRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Jobs getQslJobs(Integer id) {
        return null;
    }


}
