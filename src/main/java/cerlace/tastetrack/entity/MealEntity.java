package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.MealTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "meal")
public class MealEntity extends BaseEntity {
    @Column(nullable = false)
    private Date date;
    @Column(name = "meal_time", nullable = false)
    @Enumerated
    private MealTime mealTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private DishEntity dish;
}
