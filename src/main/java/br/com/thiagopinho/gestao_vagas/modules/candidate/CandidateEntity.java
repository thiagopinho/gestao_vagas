package br.com.thiagopinho.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "candidate")
@Data
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Length(min = 6, message = "Password should have at least 6 characters")
    private String password;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "Username should not have spaces")
    private String username;
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
