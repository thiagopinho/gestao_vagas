package br.com.thiagopinho.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class CreateJobDTO {
    @Schema(example = "Java Developer for project X", requiredMode = RequiredMode.REQUIRED)
    private String description;
    @Schema(example = "Gympass, health plan", requiredMode = RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "Junior", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
