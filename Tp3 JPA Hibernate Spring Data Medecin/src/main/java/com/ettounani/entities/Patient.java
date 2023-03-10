package com.ettounani.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient implements Serializable {

    // attributes
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String phone;
    private boolean isSingle;

}
