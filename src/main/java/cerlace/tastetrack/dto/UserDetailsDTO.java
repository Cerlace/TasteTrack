package cerlace.tastetrack.dto;

import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Goal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDetailsDTO {
    private Long user_id;
    private Float height;
    private Float weight;
    private Activity activity;
    private Goal goal;
}
