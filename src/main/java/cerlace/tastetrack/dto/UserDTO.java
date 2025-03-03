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
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {
    private String username;
    private String encodedPassword;
    private String password;
    private String passwordConfirm;
    private String fullName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private Gender gender;
    private Float height;
    private Float weight;
    private Activity activity;
    private Goal goal;
    private Set<RoleDTO> roles;
}
