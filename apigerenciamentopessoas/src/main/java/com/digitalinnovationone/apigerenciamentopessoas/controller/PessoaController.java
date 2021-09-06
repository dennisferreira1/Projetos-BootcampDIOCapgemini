package com.digitalinnovationone.apigerenciamentopessoas.controller;

import com.digitalinnovationone.apigerenciamentopessoas.dto.MensagemRespostaDTO;
import com.digitalinnovationone.apigerenciamentopessoas.dto.request.PessoaDTO;
import com.digitalinnovationone.apigerenciamentopessoas.entity.Pessoa;
import com.digitalinnovationone.apigerenciamentopessoas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO cadastrarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return this.pessoaService.cadastrar(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listarPessoas() {
        return  pessoaService.listar();
    }

}
