package br.com.thiagopinho.gestao_vagas.modules.candidate.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagopinho.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.thiagopinho.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.thiagopinho.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import br.com.thiagopinho.gestao_vagas.modules.candidate.useCases.ListAllJobsByFilterUseCase;
import br.com.thiagopinho.gestao_vagas.modules.candidate.useCases.ProfileCandidateUseCase;
import br.com.thiagopinho.gestao_vagas.modules.company.Entities.JobEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController

@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @Autowired
    private ProfileCandidateUseCase profileCandidateUseCase;

    @Autowired
    private ListAllJobsByFilterUseCase allJobsByFilterUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    @Tag(name = "Candidate", description = "Informations about candidate")
    @Operation(summary = "User profile", description = "Function to get user profile")
    @SecurityRequirement(name = "jwt_auth")
    @ApiResponses({

            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ProfileCandidateResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error to show user profile")

    })
    public ResponseEntity<Object> get(HttpServletRequest request) {

        var idCandidate = request.getAttribute("candidate_id");

        try {
            var profile = this.profileCandidateUseCase.execute(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(profile);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/job")
    @PreAuthorize("hasRole('CANDIDATE')")
    @Tag(name = "Candidate", description = "Informations about candidate")
    @Operation(summary = "List all available jobs to candidate", description = "Function to list all available jobs to candidate by filter")
    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "List of jobs", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = JobEntity.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Error to list jobs")

    })

    @SecurityRequirement(name = "jwt_auth")
    public List<JobEntity> findJobByFilter(@RequestParam String filter) {
        return this.allJobsByFilterUseCase.execute(filter);
    }
}
