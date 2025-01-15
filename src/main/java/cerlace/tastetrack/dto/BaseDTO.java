package cerlace.tastetrack.dto;

import cerlace.tastetrack.utils.interfaces.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public abstract class BaseDTO implements Identifiable {
    private Long id;
}
