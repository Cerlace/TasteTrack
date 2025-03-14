package cerlace.tastetrack.web.alert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Alert {
    private AlertCode alertCode;
    private AlertMessage alertMessage;

}
