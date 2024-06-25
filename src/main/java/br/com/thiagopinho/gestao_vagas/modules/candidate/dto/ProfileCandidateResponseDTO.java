package br.com.thiagopinho.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileCandidateResponseDTO {
    private String description;
    private String email;
    private String username;
    private String name;
    private UUID id;
}
