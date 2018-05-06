package hu.itguruk.allaskeresoportal.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="APP_ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String label;

    @ManyToMany
    Set<BaseUser> baseUsers;

    public Role(String label) {
        this.label = label;
    }

    public Role(Long id, String label) {
        this.id = id;
        this.label = label;
    }
}
