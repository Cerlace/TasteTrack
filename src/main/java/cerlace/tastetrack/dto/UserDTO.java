package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.utils.interfaces.Identifiable;
import cerlace.tastetrack.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO implements Identifiable {
    private Long id;
    private String fullName;
    private Date birthDate;
    private Gender gender;
    private String email;
    private Float height;
    private Float weight;
    private Activity activity;
    private Goal goal;
}
