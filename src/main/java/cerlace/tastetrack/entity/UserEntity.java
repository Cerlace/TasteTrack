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
@Column(name = "full_name")
    private String fullName;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column
    @Enumerated
    private Gender gender;
    @Column
    private String email;
    @Column
    private Float height;
    @Column
    private Float weight;
    @Column
    @Enumerated
    private Activity activity;
    @Column
    @Enumerated
    private Goal goal;
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<MealEntity> meals = new HashSet<>();
}
