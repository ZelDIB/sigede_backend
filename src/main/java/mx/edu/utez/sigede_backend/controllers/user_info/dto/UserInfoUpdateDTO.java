package mx.edu.utez.sigede_backend.controllers.user_info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoUpdateDTO {
    private Long fieldId;
    @JsonProperty("isRequired")
    private boolean isRequired;
    private String tag;
    private String type;
    @JsonProperty("isInQr")
    private boolean isInQr;
    @JsonProperty("isInCard")
    private boolean isInCard;

}
