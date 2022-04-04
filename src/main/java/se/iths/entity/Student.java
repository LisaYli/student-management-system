package se.iths.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty()
    @Column(unique=true)
    private String email;
    @NotEmpty()
    private String firstname;
    @NotEmpty()
    private String lastname;


    private String phoneNumber;


}
