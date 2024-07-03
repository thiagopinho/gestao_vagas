package br.com.thiagopinho.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Python Developer")
    private String description;

    @Schema(example = "user@gmail.com")
    private String email;

    @Schema(example = "Jhon")
    private String username;

    @Schema(example = "Jhon Scott")
    private String name;

    private UUID id;
}
