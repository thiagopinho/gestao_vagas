package br.com.thiagopinho.gestao_vagas.modules.candidate;

import java.util.UUID;

import lombok.Data;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String username;
    private String description;
    private String curriculum;
}
