package hu.itguruk.allaskeresoportal.entity;

import java.util.List;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity()
@Data
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
    private List<Role> role;

    public BaseUser(String username, String email, String password, List<Role> role) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole(role);
    }

    public BaseUser(Long id, String username, String email, String password, List<Role> role) {
        this(username, email, password, role);
        this.setId(id);
    }

    public BaseUser() {}

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

    public void setRole(List<Role> roles) {
        this.role = roles;
    }
}
