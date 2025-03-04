package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.MealTime;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
    @Temporal(TemporalType.DATE)
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
