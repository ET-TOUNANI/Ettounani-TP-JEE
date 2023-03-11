package com.ettounani.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Doctor implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String speciality;
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private boolean isDesponible;
}
