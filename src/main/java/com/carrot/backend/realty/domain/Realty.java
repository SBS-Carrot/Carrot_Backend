package com.carrot.backend.realty.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Realty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer realtyid;

    @Column
    String realtyUserid;


}
