package com.digitalinnovationone.apigerenciamentopessoas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

    MOBILE("Mobile"),
    HOME("Home"),
    COMERCIAL("Comercial");

    private final String descricao;

}
