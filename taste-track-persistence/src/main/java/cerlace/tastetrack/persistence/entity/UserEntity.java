package cerlace.tastetrack.persistence.entity;

import cerlace.tastetrack.persistence.enums.Activity;
import cerlace.tastetrack.persistence.enums.Gender;
import cerlace.tastetrack.persistence.enums.Goal;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString(exclude = {"meals", "authorities"})
@EqualsAndHashCode(exclude = {"meals", "authorities"}, callSuper = true)
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;
    @Column(nullable = false)
    @Enumerated
    private Gender gender;
    @Column(nullable = false)
    private Float height;
    @Column(nullable = false)
    private Float weight;
    @Column(nullable = false)
    @Enumerated
    private Activity activity;
    @Column(nullable = false)
    @Enumerated
    private Goal goal;
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<MealEntity> meals = new HashSet<>();
    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> authorities = new HashSet<>();
}
