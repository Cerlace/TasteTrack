package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.MealTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "meal", uniqueConstraints =
@UniqueConstraint(columnNames = {"user_id", "dish_id", "meal_time", "date"}))
public class MealEntity extends BaseEntity {
    @Column(nullable = false)
    private Date date;
    @Column(name = "meal_time", nullable = false)
    @Enumerated
    private MealTime mealTime;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "dish_id", nullable = false)
    private DishEntity dish;
}
