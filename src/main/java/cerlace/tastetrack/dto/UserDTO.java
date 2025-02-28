package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {
    private String fullName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private Gender gender;
    private String email;
    private Float height;
    private Float weight;
    private Activity activity;
    private Goal goal;
}
