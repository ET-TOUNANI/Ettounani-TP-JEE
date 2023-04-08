package com.ettounani.ws.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Contact {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String prenom;
    String nom;
    String email;
    String tel;
}
