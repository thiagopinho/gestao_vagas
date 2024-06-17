package br.com.thiagopinho.gestao_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
    private UUID id;

    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Name should contain only letters")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Length(min = 6, message = "Password should have at least 6 characters")
    private String password;
    private String username;
    private String description;
    private String curriculum;
}
