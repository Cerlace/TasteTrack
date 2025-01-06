package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.utils.interfaces.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user_details")
public class UserDetailsEntity implements Identifiable {
    @Id
    @Column(name = "user_id")
    private Long id;
    @Column
    private Float height;
    @Column
    private Float weight;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Activity activity;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Goal goal;

}
