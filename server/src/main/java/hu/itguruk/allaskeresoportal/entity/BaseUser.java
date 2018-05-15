package hu.itguruk.allaskeresoportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity(name = "felhasznalo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseUser {

    @Id
    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String felhasznalonev;

    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    private String jelszo;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    private Boolean engedelyezve;

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE})
    private Munkaltato munkaltato;

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE})
    private Allaskereso allaskereso;

}
