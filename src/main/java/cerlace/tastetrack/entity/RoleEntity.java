package cerlace.tastetrack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString(exclude = "users")
@EqualsAndHashCode(exclude = "users", callSuper = true)
@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity implements GrantedAuthority {

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private Set<UserEntity> users;

    @Override
    public String getAuthority() {
        return getName();
    }
}
