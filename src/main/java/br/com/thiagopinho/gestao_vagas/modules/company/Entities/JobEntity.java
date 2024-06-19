package br.com.thiagopinho.gestao_vagas.modules.company.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "job")
@Data
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Esse campo é obrigatório!")
    private String description;

    private String benefits;
    private String level;

    // @ManyToOne()
    // @JoinColumn(name = "company_id", insertable = false, updatable = false)
    // private CompanyEntity companyEntity;

    // @Column(name = "company_id", nullable = false)
    // private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}