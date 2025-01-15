package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Gender;
import cerlace.tastetrack.enums.Goal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
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
}
