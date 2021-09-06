package com.digitalinnovationone.apigerenciamentopessoas.service;

import com.digitalinnovationone.apigerenciamentopessoas.dto.MensagemRespostaDTO;
import com.digitalinnovationone.apigerenciamentopessoas.dto.request.PessoaDTO;
import com.digitalinnovationone.apigerenciamentopessoas.entity.Pessoa;
import com.digitalinnovationone.apigerenciamentopessoas.mapper.PessoaMapper;
import com.digitalinnovationone.apigerenciamentopessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository peesoaRepository) {
        this.pessoaRepository = peesoaRepository;
    }

    public MensagemRespostaDTO cadastrar(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoaCadastrar = pessoaMapper.toModel(pessoaDTO);
        Pessoa pessoaCadastrada= pessoaRepository.save(pessoaCadastrar);

        return MensagemRespostaDTO.builder()
                .mensagem("Pessoa cadastrada com sucesso. ID:  " + pessoaCadastrada.getId())
                .build();
    }

    public List<PessoaDTO> listar() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return todasPessoas.stream().map(pessoa -> pessoaMapper.toDto(pessoa)).collect(Collectors.toList());
    }
}
