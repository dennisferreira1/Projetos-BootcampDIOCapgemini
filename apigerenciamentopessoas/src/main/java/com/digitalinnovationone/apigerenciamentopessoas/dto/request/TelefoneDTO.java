package com.digitalinnovationone.apigerenciamentopessoas.dto.request;

import com.digitalinnovationone.apigerenciamentopessoas.enums.TipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    private TipoTelefone tipo;

    @NotEmpty
    @Size(min = 11, max = 14, message = "Número inválido")
    private String numero;
}
