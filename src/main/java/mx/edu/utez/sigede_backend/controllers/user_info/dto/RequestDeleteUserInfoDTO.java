package mx.edu.utez.sigede_backend.controllers.user_info.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RequestDeleteUserInfoDTO {
    @NotNull(message = "institution.id.notnull")
    private Long institutionId;
    private List<Long> fields;
}
