package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.ProductType;
import cerlace.tastetrack.utils.interfaces.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "ingredient")
public class IngredientEntity implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "product_type", nullable = false)
    @Enumerated
    private ProductType productType;
}
