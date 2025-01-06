package cerlace.tastetrack.dto;

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
public class UserDTO {
    private Long id;
    private String fullName;
    private Date birthDate;
    private Gender gender;
    private String email;
}
