package com.carrot.backend.jobs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobid;

    @Column(length = 50)
    @NotEmpty
    private String jobSubject;

    @Column
    private String jobUserid;

    private LocalDateTime createDate;

    @Column
    private String jobCategory;

    @Column
    @NotNull
    private Integer jobPrice;

    @Column
    private String jobPlace;

    @Column
    private String jobDay;

    @Column
    private String jobTime;

    @Column(length = 200)
    @NotEmpty
    private String jobContent;

    @Column
    private Integer jobVolunteer;

    @Column
    private Integer jobLike;

    @Column
    private Integer jobCheck;

}
