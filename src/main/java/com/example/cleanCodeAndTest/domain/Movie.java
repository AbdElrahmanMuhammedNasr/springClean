package com.example.cleanCodeAndTest.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;
    private  String name = UUID.randomUUID().toString();
    private  String  dept = UUID.randomUUID().toString() ;
    private  int age = new Random().nextInt(100);
    private String created_by  =UUID.randomUUID().toString();
    private Instant created_at  = Instant.now() ;
    private String modified_by =UUID.randomUUID().toString();
    private  Instant modified_at  =Instant.now();

    @Override
    public String toString() {
        return "Movie{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", dept='" + dept + '\'' +
            ", age=" + age +
            ", created_by='" + created_by + '\'' +
            ", created_at=" + created_at +
            ", modified_by='" + modified_by + '\'' +
            ", modified_at=" + modified_at +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return id != null && Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
