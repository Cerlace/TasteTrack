package cerlace.tastetrack.persistence.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductType {
    OTHER("product-type.other"),
    MEAT("product-type.meat"),
    FISH("product-type.fish"),
    VEGETABLES("product-type.vegetables"),
    FRUITS("product-type.fruits"),
    BERRIES("product-type.berries"),
    GRAINS("product-type.grains"),
    LEGUMES("product-type.legumes"),
    NUTS("product-type.nuts"),
    DAIRY("product-type.dairy"),
    SPICES("product-type.spices"),
    OILS("product-type.oils"),
    SWEETS("product-type.sweets");

    private final String messageKey;
}
