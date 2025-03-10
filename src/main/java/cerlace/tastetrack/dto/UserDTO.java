package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.enums.Gender;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    public static final int USERNAME_MIN_SIZE = 3;
    public static final int USERNAME_MAX_SIZE = 16;
    public static final int FULL_NAME_MIN_SIZE = 3;
    public static final int FILL_NAME_MAX_SIZE = 32;

    @Size(min = USERNAME_MIN_SIZE, max = USERNAME_MAX_SIZE)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String username;
    private String oldPassword;
    private String password;
    private String passwordConfirm;
    @Size(min = FULL_NAME_MIN_SIZE, max = FILL_NAME_MAX_SIZE)
    @Pattern(regexp = "^\\p{Lu}\\p{L}*(\\s\\p{Lu}\\p{L}*)*$")
    private String fullName;
    @Past
    private LocalDate birthDate;
    private Gender gender;
    private Float height;
    private Float weight;
    private Activity activity;
    private Goal goal;
    private Set<RoleDTO> authorities;
}
