package br.com.thiagopinho.gestao_vagas.modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thiagopinho.gestao_vagas.modules.company.Entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}