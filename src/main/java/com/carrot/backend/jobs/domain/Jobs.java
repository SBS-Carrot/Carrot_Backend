package com.carrot.backend.jobs.domain;

import com.carrot.backend.jobImage.domain.JobsImages;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer jobid;

    @Column(length = 50)
    @NotEmpty
     String jobSubject;

    @Column
     String jobUserid;


    LocalDateTime createDate;

    @Column
     String jobName;

    @Column
    String jobCategory;

    @Column
    @NotEmpty
     String jobPrice;

    @Column
     String jobPlace;

    @Column
     String jobDay;

    @Column
     String jobStartTime;

    @Column
    String jobEndTime;

    @Column(length = 200)
    @NotEmpty
     String jobContent;

    @Column
     Integer jobVolunteer;

    @Column
     Integer jobLike;

    @Column
     Integer jobCheck;

    @OneToMany(mappedBy = "jobs", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<JobsImages> images;
}
