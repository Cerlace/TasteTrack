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
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user_details")
public class UserDetailsEntity implements Identifiable {
    @Id
    @Column
    private Long id;
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
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private UserEntity user;
}
