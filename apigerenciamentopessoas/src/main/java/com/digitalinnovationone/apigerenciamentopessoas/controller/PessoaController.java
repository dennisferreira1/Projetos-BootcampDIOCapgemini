package com.digitalinnovationone.apigerenciamentopessoas.controller;

import com.digitalinnovationone.apigerenciamentopessoas.dto.MensagemRespostaDTO;
import com.digitalinnovationone.apigerenciamentopessoas.dto.request.PessoaDTO;
import com.digitalinnovationone.apigerenciamentopessoas.exception.PessoaNaoEncontradaException;
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

    @GetMapping("/{id}")
    public PessoaDTO buscarPessoa(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return this.pessoaService.buscarPessoa(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPessoa(@PathVariable Long id) throws PessoaNaoEncontradaException {
        this.pessoaService.excluirPessoa(id);
    }

    @PutMapping("/{id}")
    public MensagemRespostaDTO atualizarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        return this.pessoaService.atualizarPessoa(id, pessoaDTO);
    }

}
