package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {
    private String username;
    private String oldPassword;
    private String password;
    private String passwordConfirm;
    private String fullName;
    private LocalDate birthDate;
    private Gender gender;
    private Float height;
    private Float weight;
    private Activity activity;
    private Goal goal;
    private Set<RoleDTO> roles;
}
