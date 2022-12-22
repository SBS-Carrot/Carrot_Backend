package com.carrot.backend.search.domain;

import com.carrot.backend.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    long searchNum;

    @Column
    String searchWord;

    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @Column
    String category;
}
