package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Gender;
import cerlace.tastetrack.enums.Goal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString(exclude = "meals")
@EqualsAndHashCode(exclude = "meals", callSuper = true)
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    @Enumerated
    private Gender gender;
    @Column(nullable = false)
    private String email;
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
}
