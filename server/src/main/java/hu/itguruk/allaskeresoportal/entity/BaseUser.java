package hu.itguruk.allaskeresoportal.entity;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity()
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseUser {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    private String password;

    @ManyToMany
    private Set<Role> roles;


//    @JsonIgnore
//    public String getPassword() {
//        return this.password;
//    }
//
//    @JsonProperty
//    public void setPassword(String password) {
//        this.password = password;
//    }

    @OneToOne(cascade = {CascadeType.REMOVE})
    private Munkaltato munkaltato;

    @OneToOne(cascade = {CascadeType.REMOVE})
    private Allaskereso allaskereso;

}
